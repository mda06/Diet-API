package com.mda.diet.service

import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import com.fasterxml.jackson.module.kotlin.readValue
import com.mda.diet.dto.ProductDto
import com.mda.diet.model.Product
import com.mda.diet.repository.ProductRepository
import org.springframework.core.io.ClassPathResource
import org.springframework.data.domain.Pageable
import org.springframework.scheduling.annotation.Async
import org.springframework.stereotype.Service
import java.io.FileNotFoundException

@Service
class ProductService(val repository: ProductRepository) {

    @Async
    fun addBatchProducts(): Boolean {
        val mapper = jacksonObjectMapper()
        return try {
            val products = mapper.readValue<Array<Product>>(ClassPathResource("/products/products_fr.json").file)
            products.forEach {
                repository.save(it)
            }
            true
        } catch(ex: FileNotFoundException) {
            println("Cannot find the products")
            println(ex.message)
            false
        }
    }

    fun getSize() = repository.count()

    fun getProducts(pageable: Pageable, name:String?)
            = repository.findByNameLike(if(name != null) "%$name%" else "%lait e%", pageable)
            .map { ProductDto(it.id, it.name) }

    fun deleteProducts() {
        repository.deleteAll()
    }
}