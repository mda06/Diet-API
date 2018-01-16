package com.mda.diet.batch

import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import com.fasterxml.jackson.module.kotlin.readValue
import com.mda.diet.dto.ProductDto
import com.mda.diet.error.UploadFileException
import com.mda.diet.model.Product
import org.slf4j.LoggerFactory
import org.springframework.batch.item.ItemReader
import org.springframework.core.io.ClassPathResource
import java.io.File
import java.io.FileNotFoundException

class ProductReader(filePath: String) : ItemReader<Product> {
    var logger = LoggerFactory.getLogger(this.javaClass)
    var counter = 0
    var products = listOf<Product>()

    init {
        val mapper = jacksonObjectMapper()
        try {
            val lang: String
            try {
                val name = filePath.replace(".json", "")
                lang = name.substring(name.length - 2)
            } catch(e: Exception) {
                throw UploadFileException("Please submit file with name xxxxen|fr.json")
            }
            products = mapper.readValue<Array<ProductDto>>(File(filePath))
                    .map { it.toProduct(lang) }
            logger.info("${products.size} products are loaded")
        } catch(ex: FileNotFoundException) {
            logger.error("Cannot find the products")
            logger.error(ex.message)
        }
    }

    override fun read(): Product? {
        return if(counter >= products.size) {
            counter = 0
            null
        } else {
            products[counter++]
        }
    }
}