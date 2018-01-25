package com.mda.diet.service

import com.mda.diet.dto.DietFavProduct
import com.mda.diet.dto.ProductDto
import com.mda.diet.dto.ProductNameDto
import com.mda.diet.error.CustomNotFoundException
import com.mda.diet.error.FavException
import com.mda.diet.error.ProductSortException
import com.mda.diet.error.UploadFileException
import com.mda.diet.repository.DietetistRepository
import com.mda.diet.repository.ProductRepository
import com.mda.diet.repository.ProductTranslationRepository
import org.slf4j.LoggerFactory
import org.springframework.batch.core.Job
import org.springframework.batch.core.launch.JobLauncher
import org.springframework.dao.InvalidDataAccessApiUsageException
import org.springframework.data.domain.Pageable
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Service
import org.springframework.web.multipart.MultipartFile
import org.springframework.batch.core.JobParametersBuilder
import org.springframework.data.domain.Page
import org.springframework.scheduling.annotation.Async
import java.io.File
import java.util.concurrent.CompletableFuture

@Service
class ProductService(val repository: ProductRepository,
                     val translationRepository: ProductTranslationRepository,
                     val dietRepo: DietetistRepository,
                     val job: Job,
                     val jobLauncher: JobLauncher) {

    val logger = LoggerFactory.getLogger(this.javaClass)!!

    @Deprecated("Not longer used", ReplaceWith("uploadBatch"))
    fun addBatchProducts(): Boolean {
        /*val mapper = jacksonObjectMapper()
        return try {
            val products = mapper.readValue<Array<ProductDto>>(ClassPathResource("/products/products_fr.json").file)
            products.forEach {
                val prod = it.toProduct("fr")
                repository.save(prod)
            }

            val productsEn = mapper.readValue<Array<ProductDto>>(ClassPathResource("/products/products_en.json").file)
            productsEn.forEach {
                val prod = it.toProduct("en")
                repository.save(prod)
            }

            true
        } catch(ex: FileNotFoundException) {
            println("Cannot find the products")
            println(ex.message)
            false
        }*/
        return false
    }

    fun getSize() = repository.count()

    fun getProductById(id: Long, language: String?, diet: Long? = null) : ProductDto {
        val prod = repository.findByIdAndTranslationsLanguageEquals(id, language ?: "en")
                ?: throw CustomNotFoundException("Not found product with id $id")
        return ProductDto(prod, prod.dietetists.stream().anyMatch { it.id == diet })
    }

    fun getProducts(pageable: Pageable?, name: String?, language: String?) =
        try {
            translationRepository.findByLanguageAndNameLike(language?: "en",
                    if(name != null) "%$name%" else "%", pageable)
        } catch (ex: InvalidDataAccessApiUsageException) {
            throw ProductSortException("Cannot sort product")
        }

    fun getProductsFromFav(language: String?, diet: Long?, pageable: Pageable?): Page<ProductNameDto> {
        val prods = repository.findByDietetistsIdIs(diet ?: 0, pageable)
        prods.map { it.translations.removeIf { it.language != language?: "en" } }
        return prods.map { ProductNameDto(it) }
    }

    fun deleteProducts() {
        logger.info("Deleting products")
        repository.deleteAll()
        logger.info("All products are deleted")
    }

    fun deleteProduct(id: Long) {
        repository.delete(id)
    }

    @Async
    fun uploadBatch(uploadFile: MultipartFile): CompletableFuture<ResponseEntity<String>> {
        if(uploadFile.isEmpty) throw UploadFileException("File is empty")
        val lang: String
        try {
            val name = uploadFile.originalFilename.replace(".json", "")
            lang = name.substring(name.length - 2)
        } catch(e: Exception) {
            throw UploadFileException("Please submit file with name xxxxen|fr.json")
        }

        if(lang != "fr" && lang != "en")
            throw UploadFileException("Please submit products with 'fr' or 'en'")

        //Save file
        try {
            val basePath = System.getProperty("user.dir") + "/products"
            if(!File(basePath).exists()) File(basePath).mkdir()
            val fullPath = "$basePath/${uploadFile.originalFilename}"
            File(fullPath).writeBytes(uploadFile.bytes)

            logger.info("Starting job")
            val jobParameters = JobParametersBuilder().addLong("time", System.currentTimeMillis())
                    .addString("file", fullPath)
                    .toJobParameters()
            jobLauncher.run(job, jobParameters)
            return CompletableFuture.completedFuture(
                    ResponseEntity("Successfully uploaded ${uploadFile.originalFilename}", HttpStatus.OK))
        } catch (e: Exception) {
            e.printStackTrace()
            logger.error(e.message)
            throw UploadFileException("Error while saving the products")
        }
    }

    fun addProdToFav(fav: DietFavProduct): Any {
        val diet = dietRepo.findOne(fav.diet_id) ?: throw FavException("No diet exist with id: ${fav.diet_id}")
        val prod = repository.findOne(fav.prod_id) ?: throw FavException("No product exist with id: ${fav.prod_id}")
        diet.favoriteProducts.add(prod)
        prod.dietetists.add(diet)
        dietRepo.save(diet)
        return true
    }

    fun removeProdFromFav(fav: DietFavProduct): Any {
        val diet = dietRepo.findOne(fav.diet_id) ?: throw FavException("No diet exist with id: ${fav.diet_id}")
        val prod = repository.findOne(fav.prod_id) ?: throw FavException("No product exist with id: ${fav.prod_id}")
        diet.favoriteProducts.remove(prod)
        prod.dietetists.remove(diet)
        dietRepo.save(diet)
        return true
    }

}