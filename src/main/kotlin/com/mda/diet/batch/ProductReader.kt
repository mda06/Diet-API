package com.mda.diet.batch

import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import com.fasterxml.jackson.module.kotlin.readValue
import com.mda.diet.dto.ProductDto
import com.mda.diet.model.Product
import org.slf4j.LoggerFactory
import org.springframework.batch.core.configuration.annotation.StepScope
import org.springframework.batch.item.ItemReader
import org.springframework.beans.factory.annotation.Value
import org.springframework.core.io.ClassPathResource
import java.io.FileNotFoundException

class ProductReader(val filePath: String) : ItemReader<Product> {
    var logger = LoggerFactory.getLogger(this.javaClass)
    var counter = 0
    var products = listOf<Product>()

    init {
        val mapper = jacksonObjectMapper()
        try {
            products = mapper.readValue<Array<ProductDto>>(ClassPathResource(filePath).file)
                    .map { it.toProduct("fr") }
            logger.info("${products.size} products are loaded")
        } catch(ex: FileNotFoundException) {
            logger.error("Cannot find the products")
            logger.error(ex.message)
        }
    }

    override fun read(): Product? {
        return null
        if(counter >= products.size) {
            counter = 0
            return null
        } else {
            return products[counter++]
        }
    }
}