package com.mda.diet.batch

import com.mda.diet.model.Product
import com.mda.diet.repository.ProductRepository
import org.slf4j.LoggerFactory
import org.springframework.batch.item.ItemWriter
import org.springframework.beans.factory.annotation.Autowired

class ProductWriter: ItemWriter<Product> {
    var logger = LoggerFactory.getLogger(this.javaClass)
    @Autowired
    val repository: ProductRepository? = null

    override fun write(list: MutableList<out Product>?) {
        //repository!!.save(list)

        logger.info(list!!.size.toString())
    }
}