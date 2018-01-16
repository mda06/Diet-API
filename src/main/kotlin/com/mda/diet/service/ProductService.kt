package com.mda.diet.service

import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import com.fasterxml.jackson.module.kotlin.readValue
import com.mda.diet.dto.ProductDto
import com.mda.diet.dto.ProductNameDto
import com.mda.diet.error.CustomNotFoundException
import com.mda.diet.error.ProductSortException
import com.mda.diet.error.UploadFileException
import com.mda.diet.repository.ProductRepository
import com.mda.diet.repository.ProductTranslationRepository
import org.slf4j.LoggerFactory
import org.springframework.batch.core.Job
import org.springframework.batch.core.launch.JobLauncher
import org.springframework.core.io.ClassPathResource
import org.springframework.dao.InvalidDataAccessApiUsageException
import org.springframework.data.domain.Pageable
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Service
import org.springframework.web.multipart.MultipartFile
import java.io.FileNotFoundException
import javax.transaction.Transactional
import org.springframework.batch.core.JobParametersBuilder
import org.springframework.batch.core.JobParameters



@Service
class ProductService(val repository: ProductRepository,
                     val translationRepository: ProductTranslationRepository,
                     val job: Job,
                     val jobLauncher: JobLauncher) {

    val logger = LoggerFactory.getLogger(this.javaClass)!!

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

        return try {
            logger.info("Starting job")
            val jobParameters = JobParametersBuilder().addLong("time", System.currentTimeMillis())
                    .toJobParameters()
            logger.info("Running job")
            jobLauncher.run(job, jobParameters)
            logger.warn("Job done")
            true
        } catch (e: Exception) {
            logger.info(e.message)
            false
        }
    }

    fun getSize() = repository.count()

    fun getProductById(id: Long, language: String?) : ProductDto {
        val prod = repository.findByIdAndTranslationsLanguageEquals(id, language ?: "en")
                ?: throw CustomNotFoundException("Not found product with id $id")
        return ProductDto(prod)
    }

    fun getProducts(pageable: Pageable?, name: String?, language: String?) =
        try {
            translationRepository.findByLanguageAndNameLike(language?: "en",
                    if(name != null) "%$name%" else "%", pageable)
            /*repository.findByTranslationsLanguageEqualsAndTranslationsNameLike(language?: "en",
                    if(name != null) "%$name%" else "%", pageable)
                    .map {
                        ProductNameDto(it)
                    }*/
        } catch (ex: InvalidDataAccessApiUsageException) {
            throw ProductSortException("Cannot sort product")
        }

    fun deleteProducts() {
        repository.deleteAll()
    }

    fun deleteProduct(id: Long) {
        repository.delete(id)
    }

    @Transactional
    fun uploadBatch(uploadFile: MultipartFile): ResponseEntity<Any> {
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

        val mapper = jacksonObjectMapper()
        val products = mapper.readValue<Array<ProductDto>>(uploadFile.inputStream)
        products.forEach { val prod = it.toProduct(lang); repository.save(prod); }

        return ResponseEntity("Successfully uploaded ${uploadFile.originalFilename}" +
                " with ${products.size} products", HttpStatus.OK)
    }
}