package com.mda.diet.service

import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import com.fasterxml.jackson.module.kotlin.readValue
import com.mda.diet.model.Nutriment
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

    fun getProducts(pageable: Pageable) = repository.findAll(pageable)

    fun deleteProducts() {
        repository.deleteAll()
    }

    fun addTestProduct() : Product {
        val p = Product(100L, "coca", "url")
        //p.units.add(Nutriment(0, "càs", 1.0, "g"))
        p.micros.add(Nutriment(0, "magnesium", 1.5, "mg"))
        p.micros.add(Nutriment(0, "sel", 0.0, "mg"))
        //p.macros.add(Nutriment(0, "poivre", 1.0, "mg"))
        return repository.save(p)
    }
}