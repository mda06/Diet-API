package com.mda.diet.api.service

import com.mda.diet.repository.ProductRepository
import com.mda.diet.service.ProductService
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.InjectMocks
import org.mockito.Mock
import org.springframework.test.context.junit4.SpringRunner


@RunWith(SpringRunner::class)
class ProductServiceTest {

    @Mock
    var repository: ProductRepository? = null

    @InjectMocks
    var service: ProductService? = null

    @Test
    fun testaddBatchProducts() {
        /*service!!.addBatchProducts().take(10).forEach({
            println("${it.id} for ${it.name}")
        })*/
    }
}