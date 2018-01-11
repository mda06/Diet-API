package com.mda.diet.service

import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import com.fasterxml.jackson.module.kotlin.readValue
import com.mda.diet.dto.ProductDto
import com.mda.diet.dto.ProductNameDto
import com.mda.diet.error.CustomNotFoundException
import com.mda.diet.repository.ProductRepository
import org.springframework.core.io.ClassPathResource
import org.springframework.data.domain.Pageable
import org.springframework.stereotype.Service
import java.io.FileNotFoundException
import javax.transaction.Transactional

@Service
class ProductService(val repository: ProductRepository) {

    @Transactional
    fun addBatchProducts(): Boolean {
        val mapper = jacksonObjectMapper()
        return try {
            val products = mapper.readValue<Array<ProductDto>>(ClassPathResource("/products/products_fr.json").file)
            products.take(25).forEach {
                val prod = it.toProduct("fr")
                repository.save(prod)
            }

            val productsEn = mapper.readValue<Array<ProductDto>>(ClassPathResource("/products/products_en.json").file)
            productsEn.take(25).forEach {
                val prod = it.toProduct("en")
                repository.save(prod)
            }

            true
        } catch(ex: FileNotFoundException) {
            println("Cannot find the products")
            println(ex.message)
            false
        }
    }

    fun getSize() = repository.count()

    fun getProductById(id: Long, language: String?) : ProductDto {
        val prod = repository.findByIdAndTranslationsLanguageEquals(id, language ?: "en")
                ?: throw CustomNotFoundException("Not found product with id $id")
        return ProductDto(prod)
    }

    fun getProducts(pageable: Pageable, name: String?, language: String?)
            = repository.findByTranslationsLanguageEqualsAndTranslationsNameLike(language?: "en",
                    if(name != null) "%$name%" else "%",
                    pageable)
            .map {
                ProductNameDto(it)
            }

    fun deleteProducts() {
        repository.deleteAll()
    }
}