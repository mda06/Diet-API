package com.mda.diet.batch

import com.mda.diet.model.Product
import com.mda.diet.repository.ProductRepository
import org.slf4j.LoggerFactory
import org.springframework.batch.item.ItemWriter

class ProductWriter(val repository: ProductRepository): ItemWriter<Product> {
    var logger = LoggerFactory.getLogger(this.javaClass)

    override fun write(list: MutableList<out Product>?) {
        logger.info("Saving ${list!!.size} products")
        repository.save(list)
    }
}