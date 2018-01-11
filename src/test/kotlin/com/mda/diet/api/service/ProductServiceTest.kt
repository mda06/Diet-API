package com.mda.diet.api.service

import com.mda.diet.error.CustomNotFoundException
import com.mda.diet.model.Product
import com.mda.diet.model.ProductTranslation
import com.mda.diet.repository.ProductRepository
import com.mda.diet.service.ProductService
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.Mockito
import org.springframework.test.context.junit4.SpringRunner
import kotlin.test.*


@RunWith(SpringRunner::class)
class ProductServiceTest {

    @Mock
    var repository: ProductRepository? = null

    @InjectMocks
    var service: ProductService? = null

    @Test
    fun testSize() {
        Mockito.`when`(repository!!.count()).thenReturn(0)
        assertEquals(0, service!!.getSize())
        Mockito.`when`(repository!!.count()).thenReturn(15)
        assertEquals(15, service!!.getSize())
    }

    @Test
    fun testGetProductByIdSuccessLanguage() {
        Mockito.`when`(repository!!.findByIdAndTranslationsLanguageEquals(5633, "en"))
                .thenReturn(Product(5633)
                        .also { it.translations.add(ProductTranslation(1, "en", "Apricot"))
                            it.translations.add(ProductTranslation(2, "fr", "Abricot"))}
                )
        val prod = service!!.getProductById(5633, "en")
        assertEquals("Apricot", prod.name)
    }

    @Test
    fun testGetProductByIdFailId() {
        Mockito.`when`(repository!!.findByIdAndTranslationsLanguageEquals(5632, "en"))
                .thenReturn(null)
        try {
            service!!.getProductById(5632, "en")
            fail("Whould throw a exception")
        } catch(ex: CustomNotFoundException) {
            assertEquals("Not found product with id 5632", ex.message)
        }
    }
}