package com.mda.diet.api.service

import com.mda.diet.dto.MealProductDto
import com.mda.diet.error.CustomNotFoundException
import com.mda.diet.model.Meal
import com.mda.diet.model.MealProduct
import com.mda.diet.model.Product
import com.mda.diet.repository.MealProductRepository
import com.mda.diet.repository.MealRepository
import com.mda.diet.repository.ProductRepository
import com.mda.diet.service.MealProductService
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.Mockito
import org.springframework.dao.EmptyResultDataAccessException
import org.springframework.test.context.junit4.SpringRunner
import kotlin.test.assertEquals
import kotlin.test.fail


@RunWith(SpringRunner::class)
class MealProductServiceTest {

    init {
        System.setProperty("spring.config.name", "test")
        System.setProperty("spring.profiles.active", "test")
    }

    @Mock
    var repository: MealProductRepository? = null

    @Mock
    var mealRepository: MealRepository? = null

    @Mock
    var productRepo: ProductRepository? = null

    @InjectMocks
    var service: MealProductService? = null

    @Test
    fun testAddMealWhenProductNotExsist() {
        val dto = MealProductDto(0, 0, 1)
        Mockito.`when`(productRepo!!.findOne(1)).thenReturn(null)
        try {
            service!!.addMealProduct(dto)
            fail("Must throw CustomNotFoundException when the product not exist")
        } catch(ex: CustomNotFoundException) {
            assertEquals("No product exists with id 1", ex.message)
        }
    }

    @Test
    fun testAddMealWhenMealNotExist() {
        val dto = MealProductDto(0, 0, 1, 2)
        Mockito.`when`(mealRepository!!.findOne(2)).thenReturn(null)
        Mockito.`when`(productRepo!!.findOne(1)).thenReturn(Product(1))
        try {
            service!!.addMealProduct(dto)
            fail("Must throw CustomNotFoundException when the product not exist")
        } catch(ex: CustomNotFoundException) {
            assertEquals("No meal exists with id 2", ex.message)
        }
    }

    @Test
    fun testAddMealSuccess() {
        val dto = MealProductDto(0, 130, 1, 2)
        Mockito.`when`(productRepo!!.findOne(Mockito.any())).thenAnswer {
            Product(it.getArgumentAt(0, Long::class.java))
        }
        Mockito.`when`(mealRepository!!.findOne(2)).thenReturn(Meal(2))
        Mockito.`when`(repository!!.save(Mockito.any<MealProduct>()))
                .thenReturn(MealProduct(1, Meal(2), Product(1), 130))

        val mp = service!!.addMealProduct(dto)
        assertEquals(1, mp.id)
        assertEquals(dto.mealId, mp.mealId)
        assertEquals(dto.productId, mp.productId)
        assertEquals(dto.quantity, mp.quantity)
    }

    @Test
    fun testCount() {
        Mockito.`when`(repository!!.countByProductId(1)).thenReturn(15)
        assertEquals(15, service!!.countByProductId(1))
    }

    @Test
    fun testGetNotExist() {
        Mockito.`when`(repository!!.findOne(1)).thenReturn(null)
        try {
            service!!.getById(1)
            fail("Must throw CustomNotFoundException when the meal not exist")
        } catch(ex: CustomNotFoundException) {
            assertEquals("No mealproduct exist with id 1", ex.message)
        }
    }

    @Test
    fun testGetSuccess() {
        Mockito.`when`(repository!!.findOne(2)).thenReturn(MealProduct(2))
        assertEquals(2, service!!.getById(2).id)
    }


    @Test
    fun testDeleteWhenNotExsist() {
        Mockito.`when`(repository!!.delete(1)).thenThrow(EmptyResultDataAccessException::class.java)
        try {
            service!!.deleteMealProduct(1)
            fail("Must throw EmptyResultDataAccessException when the meal not exist")
        } catch(ex: EmptyResultDataAccessException) {}
    }

    @Test
    fun testDeleteSuccess() {
        service!!.deleteMealProduct(2)
    }
}