package com.mda.diet.api.service

import com.mda.diet.model.Product
import com.mda.diet.model.ProductTranslation
import com.mda.diet.repository.ProductRepository
import com.mda.diet.service.ProductService
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.Mockito
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.test.context.junit4.SpringRunner
import kotlin.test.*


@RunWith(SpringRunner::class)
class ProductServiceTest {

    @Mock
    var repository: ProductRepository? = null

    @InjectMocks
    var service: ProductService? = null

    @Test
    fun testGetProductById() {
        Mockito.`when`(repository!!.findByIdAndTranslationsLanguageEquals(5633, "en"))
                .thenReturn(Product(5633)
                        .also { it.translations.add(ProductTranslation(1, "en", "Apricot")) }
                )
        val prod = service!!.getProductById(5633, "en")
        assertEquals("Apricot", prod.name)
    }
}