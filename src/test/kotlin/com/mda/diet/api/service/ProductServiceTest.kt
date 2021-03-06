package com.mda.diet.api.service

import com.mda.diet.dto.DietFavProduct
import com.mda.diet.dto.ProductNameDto
import com.mda.diet.error.CustomNotFoundException
import com.mda.diet.error.FavException
import com.mda.diet.model.Dietetist
import com.mda.diet.model.Product
import com.mda.diet.model.ProductTranslation
import com.mda.diet.repository.DietetistRepository
import com.mda.diet.repository.ProductRepository
import com.mda.diet.repository.ProductTranslationRepository
import com.mda.diet.service.ProductService
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.Mockito
import org.springframework.batch.core.Job
import org.springframework.batch.core.launch.JobLauncher
import org.springframework.test.context.junit4.SpringRunner
import kotlin.test.*


@RunWith(SpringRunner::class)
class ProductServiceTest {

    init {
        System.setProperty("spring.config.name", "test")
        System.setProperty("spring.profiles.active", "test")
    }

    @Mock
    var repository: ProductRepository? = null

    @Mock
    var repositoryTranslate: ProductTranslationRepository? = null

    @Mock
    var job: Job? = null

    @Mock
    var jobLauncher: JobLauncher? = null

    @Mock
    var dietRepo: DietetistRepository? = null

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
    fun testGetProductByIdIsFav() {
        Mockito.`when`(repository!!.findByIdAndTranslationsLanguageEquals(33, "en"))
                .thenReturn(Product(33)
                        .also { it.translations.add(ProductTranslation(1, "en", "Apricot"))
                            it.dietetists.add(Dietetist(20))
                            it.dietetists.add(Dietetist(22))}
                )
        val prod = service!!.getProductById(33, "en", 20)
        assertEquals(true, prod.favorite)
    }

    @Test
    fun testGetProductByIdIsNotFav() {
        Mockito.`when`(repository!!.findByIdAndTranslationsLanguageEquals(33, "en"))
                .thenReturn(Product(33)
                        .also { it.translations.add(ProductTranslation(1, "en", "Apricot"))
                            it.dietetists.add(Dietetist(20))
                            it.dietetists.add(Dietetist(22))}
                )
        val prod = service!!.getProductById(33, "en", 21)
        assertEquals(false, prod.favorite)
    }

    @Test
    fun testAddFavDietIsNull() {
        Mockito.`when`(dietRepo!!.findOne(2)).thenReturn(null)
        Mockito.`when`(repository!!.findOne(1234)).thenReturn(Product(1234))
        try {
            service!!.addProdToFav(DietFavProduct(1234, 2))
            fail("Must throw FavException because no diet exists with id 2")
        } catch(ex: FavException) {
            assertEquals("No diet exist with id: 2", ex.message)
        }
    }

    @Test
    fun testAddFavProdIsNull() {
        Mockito.`when`(dietRepo!!.findOne(2)).thenReturn(Dietetist(2))
        Mockito.`when`(repository!!.findOne(1234)).thenReturn(null)
        try {
            service!!.addProdToFav(DietFavProduct(1234, 2))
            fail("Must throw FavException because no prod exists with id 1234")
        } catch(ex: FavException) {
            assertEquals("No product exist with id: 1234", ex.message)
        }
    }
    @Test
    fun testAddFavSuccess() {
        Mockito.`when`(dietRepo!!.findOne(2)).thenReturn(Dietetist(2))
        Mockito.`when`(repository!!.findOne(1234)).thenReturn(Product(1234))
        val ret = service!!.addProdToFav(DietFavProduct(1234, 2))
        assertTrue(ret as Boolean)
    }

    @Test
    fun testRemoveFavDietIsNull() {
        Mockito.`when`(dietRepo!!.findOne(2)).thenReturn(null)
        Mockito.`when`(repository!!.findOne(1234)).thenReturn(Product(1234))
        try {
            service!!.removeProdFromFav(DietFavProduct(1234, 2))
            fail("Must throw FavException because no diet exists with id 2")
        } catch(ex: FavException) {
            assertEquals("No diet exist with id: 2", ex.message)
        }
    }

    @Test
    fun testRemoveFavProdIsNull() {
        Mockito.`when`(dietRepo!!.findOne(2)).thenReturn(Dietetist(2))
        Mockito.`when`(repository!!.findOne(1234)).thenReturn(null)
        try {
            service!!.removeProdFromFav(DietFavProduct(1234, 2))
            fail("Must throw FavException because no prod exists with id 1234")
        } catch(ex: FavException) {
            assertEquals("No product exist with id: 1234", ex.message)
        }
    }

    @Test
    fun testRemoveFavSuccess() {
        Mockito.`when`(dietRepo!!.findOne(2)).thenReturn(Dietetist(2))
        Mockito.`when`(repository!!.findOne(1234)).thenReturn(Product(1234))
        val ret = service!!.removeProdFromFav(DietFavProduct(1234, 2))
        assertTrue(ret as Boolean)
    }

    @Test
    fun testGetProductsSuccessWithoutName() {
        Mockito.`when`(repositoryTranslate!!.findByLanguageAndNameLike("fr", "%", null))
                .thenReturn(org.springframework.data.domain.PageImpl<ProductNameDto>(arrayListOf(
                        ProductNameDto(1, "Lait"),
                        ProductNameDto(2, "Fraise")
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
        Mockito.`when`(repositoryTranslate!!.findByLanguageAndNameLike("fr", "%La%", null))
                .thenReturn(org.springframework.data.domain.PageImpl<ProductNameDto>(arrayListOf(
                        ProductNameDto(1, "Lait")
                )))
        val prods = service!!.getProducts(null, "La", "fr")
        assertEquals(1, prods.numberOfElements)
        assertEquals(1, prods.content[0].id)
        assertEquals("Lait", prods.content[0].name)
    }


    @Test
    fun testGetProductsUndefinedLanguage() {
        Mockito.`when`(repositoryTranslate!!.findByLanguageAndNameLike("nl", "%", null))
                .thenReturn(org.springframework.data.domain.PageImpl<ProductNameDto>(arrayListOf()))
        val prods = service!!.getProducts(null, null, "nl")
        assertEquals(0, prods.numberOfElements)
    }


}