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

    @Test
    fun testGetProductsSuccessWithoutName() {
        Mockito.`when`(repository!!.findByTranslationsLanguageEqualsAndTranslationsNameLike("fr", "%", null))
                .thenReturn(org.springframework.data.domain.PageImpl<Product>(arrayListOf(
                        Product(1).also { it.translations.add(ProductTranslation(1, "fr", "Lait")) },
                        Product(2).also { it.translations.add(ProductTranslation(2, "fr", "Fraise")) }
                )))
        val prods = service!!.getProducts(null, null, "fr")
        assertEquals(2, prods.numberOfElements)
        assertEquals(1, prods.content[0].id)
        assertEquals("Lait", prods.content[0].name)
        assertEquals(2, prods.content[1].id)
        assertEquals("Fraise", prods.content[1].name)
    }

    @Test
    fun testGetProductsSuccessWithName() {
        Mockito.`when`(repository!!.findByTranslationsLanguageEqualsAndTranslationsNameLike("fr", "%La%", null))
                .thenReturn(org.springframework.data.domain.PageImpl<Product>(arrayListOf(
                        Product(1).also { it.translations.add(ProductTranslation(1, "fr", "Lait")) }
                )))
        val prods = service!!.getProducts(null, "La", "fr")
        assertEquals(1, prods.numberOfElements)
        assertEquals(1, prods.content[0].id)
        assertEquals("Lait", prods.content[0].name)
    }


    @Test
    fun testGetProductsUndefinedLanguage() {
        Mockito.`when`(repository!!.findByTranslationsLanguageEqualsAndTranslationsNameLike("nl", "%", null))
                .thenReturn(org.springframework.data.domain.PageImpl<Product>(arrayListOf()))
        val prods = service!!.getProducts(null, null, "nl")
        assertEquals(0, prods.numberOfElements)
    }


}