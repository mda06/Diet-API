package com.mda.diet.api.service

import com.mda.diet.dto.MealDto
import com.mda.diet.dto.MealProductDto
import com.mda.diet.dto.MenuDto
import com.mda.diet.error.CustomNotFoundException
import com.mda.diet.model.*
import com.mda.diet.repository.*
import com.mda.diet.service.MealService
import com.mda.diet.service.MenuService
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.AdditionalAnswers
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.Mockito
import org.springframework.dao.EmptyResultDataAccessException
import org.springframework.dao.InvalidDataAccessApiUsageException
import org.springframework.test.context.junit4.SpringRunner
import java.time.LocalDate
import kotlin.test.assertEquals
import kotlin.test.fail


@RunWith(SpringRunner::class)
class MealServiceTest {

    init {
        System.setProperty("spring.config.name", "test")
        System.setProperty("spring.profiles.active", "test")
    }

    @Mock
    var repository: MealRepository? = null

    @Mock
    var menuRepository: MenuRepository? = null

    @Mock
    var dietRepository: DietetistRepository? = null

    @Mock
    var productRepo: ProductRepository? = null

    @InjectMocks
    var service: MealService? = null

    @Test
    fun testAddMealWhenProductNotExist() {
        val dto = MealDto(0, 1,0, "", "", 0, "",
                listOf(MealProductDto(0, 0, 1)))
        Mockito.`when`(productRepo!!.findOne(1)).thenReturn(null)
        try {
            service!!.addMeal(dto)
            fail("Must throw CustomNotFoundException when the product not exist")
        } catch(ex: CustomNotFoundException) {
            assertEquals("No product exists with id 1", ex.message)
        }
    }

    @Test
    fun testAddMealWhenMenuAndDietNotExist() {
        val dto = MealDto(0, 1,2, "", "", 0, "",
                listOf(MealProductDto(0, 0, 1)))
        Mockito.`when`(productRepo!!.findOne(Mockito.any())).thenAnswer {
            Product(it.getArgumentAt(0, Long::class.java))
        }
        Mockito.`when`(menuRepository!!.findOne(2)).thenReturn(null)
        Mockito.`when`(dietRepository!!.findOne(1)).thenReturn(null)
        try {
            service!!.addMeal(dto)
            fail("Must throw CustomNotFoundException when the menu not exist")
        } catch(ex: CustomNotFoundException) {
            assertEquals("No menu exist with id 2 and no diet exist with id 1", ex.message)
        }
    }

    @Test
    fun testAddMealDietIsNullSuccess() {
        val dto = MealDto(0, 1, 2, "Lunch", "Not to much fat", 0, "",
                listOf(MealProductDto(0, 150, 1),
                        MealProductDto(0, 50, 2),
                        MealProductDto(0, 300, 3)))
        Mockito.`when`(productRepo!!.findOne(Mockito.any())).thenAnswer {
            Product(it.getArgumentAt(0, Long::class.java))
        }
        Mockito.`when`(menuRepository!!.findOne(2)).thenReturn(Menu(2))
        Mockito.`when`(dietRepository!!.findOne(1)).thenReturn(null)
        Mockito.`when`(repository!!.save(Mockito.any<Meal>()))
                .thenReturn(Meal(1, dto.name, dto.extraInfo, dto.score, dto.comment, Menu(dto.menuId),
                        mutableListOf(MealProduct(1, Meal(1), Product(1), 150),
                                MealProduct(2, Meal(1), Product(2), 50),
                                MealProduct(3, Meal(1), Product(3), 300))))

        val meal = service!!.addMeal(dto)
        assertEquals(1, meal.id)
        assertEquals(dto.menuId, meal.menuId)
        assertEquals(0, meal.dietId)
        assertEquals(dto.name, meal.name)
        assertEquals(dto.extraInfo, meal.extraInfo)
        assertEquals(dto.score, meal.score)
        assertEquals(dto.comment, meal.comment)
        for(j in meal.mealProducts.indices) {
            assertEquals(dto.mealProducts[j].quantity, meal.mealProducts[j].quantity)
            assertEquals(dto.mealProducts[j].productId, meal.mealProducts[j].productId)
            assertEquals(j.toLong() + 1, meal.mealProducts[j].id)
        }
    }

    @Test
    fun testAddMealMenuIsNullSuccess() {
        val dto = MealDto(0, 1, 2, "Lunch", "Not to much fat", 0, "",
                listOf(MealProductDto(0, 150, 1),
                        MealProductDto(0, 50, 2),
                        MealProductDto(0, 300, 3)))
        Mockito.`when`(productRepo!!.findOne(Mockito.any())).thenAnswer {
            Product(it.getArgumentAt(0, Long::class.java))
        }
        Mockito.`when`(menuRepository!!.findOne(2)).thenReturn(null)
        Mockito.`when`(dietRepository!!.findOne(1)).thenReturn(Dietetist(1))
        Mockito.`when`(repository!!.save(Mockito.any<Meal>()))
                .thenReturn(Meal(1, dto.name, dto.extraInfo, dto.score, dto.comment, null,
                        mutableListOf(MealProduct(1, Meal(1), Product(1), 150),
                                MealProduct(2, Meal(1), Product(2), 50),
                                MealProduct(3, Meal(1), Product(3), 300)), Dietetist(dto.dietId)))

        val meal = service!!.addMeal(dto)
        assertEquals(1, meal.id)
        assertEquals(0, meal.menuId)
        assertEquals(dto.dietId, meal.dietId)
        assertEquals(dto.name, meal.name)
        assertEquals(dto.extraInfo, meal.extraInfo)
        assertEquals(dto.score, meal.score)
        assertEquals(dto.comment, meal.comment)
        for(j in meal.mealProducts.indices) {
            assertEquals(dto.mealProducts[j].quantity, meal.mealProducts[j].quantity)
            assertEquals(dto.mealProducts[j].productId, meal.mealProducts[j].productId)
            assertEquals(j.toLong() + 1, meal.mealProducts[j].id)
        }
    }

    @Test
    fun testGetNotExist() {
        Mockito.`when`(repository!!.findOne(1)).thenReturn(null)
        try {
            service!!.getById(1)
            fail("Must throw CustomNotFoundException when the meal not exist")
        } catch(ex: CustomNotFoundException) {
            assertEquals("No meal exist with id 1", ex.message)
        }
    }

    @Test
    fun testGetSuccess() {
        Mockito.`when`(repository!!.findOne(2)).thenReturn(Meal(2))
        assertEquals(2, service!!.getById(2).id)
    }


    @Test
    fun testDeleteWhenNotExsist() {
        Mockito.`when`(repository!!.delete(1)).thenThrow(EmptyResultDataAccessException::class.java)
        try {
            service!!.deleteMeal(1)
            fail("Must throw EmptyResultDataAccessException when the meal not exist")
        } catch(ex: EmptyResultDataAccessException) {}
    }

    @Test
    fun testDeleteSuccess() {
        service!!.deleteMeal(2)
    }
}