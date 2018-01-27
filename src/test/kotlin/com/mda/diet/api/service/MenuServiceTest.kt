package com.mda.diet.api.service

import com.mda.diet.dto.MealDto
import com.mda.diet.dto.MealProductDto
import com.mda.diet.dto.MenuDto
import com.mda.diet.error.CustomNotFoundException
import com.mda.diet.model.*
import com.mda.diet.repository.MenuRepository
import com.mda.diet.repository.PatientRepository
import com.mda.diet.repository.ProductRepository
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
class MenuServiceTest {

    @Mock
    var repository: MenuRepository? = null

    @Mock
    var patientRepo: PatientRepository? = null

    @Mock
    var productRepo: ProductRepository? = null

    @InjectMocks
    var service: MenuService? = null

    @Test
    fun testAddMenuWhenPatientNotExsist() {
        Mockito.`when`(patientRepo!!.findOne(1)).thenReturn(null)
        try {
            service!!.addMenu(MenuDto(0, 1, null, listOf()))
          fail("Must throw CustomNotFoundException when the patient not exist")
        } catch(ex: CustomNotFoundException) {
            assertEquals("No patient exists with id 1", ex.message)
        }
    }

    //Success
    @Test
    fun testAddMenuSuccess() {
        val dto = MenuDto(0, 1, LocalDate.of(2018, 1, 25), listOf(
                MealDto(0, 0, "Breakfast", "Don't use to much oil", 0, "",
                        listOf(MealProductDto(150, 1), MealProductDto(200, 2))),
                MealDto(0, 0, "Diner", "Chicken not burned", 0, "",
                        listOf(MealProductDto(50, 3), MealProductDto(300, 4)))
        ))
        Mockito.`when`(patientRepo!!.findOne(Mockito.any())).thenAnswer {
            Patient(it.getArgumentAt(0, Long::class.java))
        }

        Mockito.`when`(productRepo!!.findOne(Mockito.any())).thenAnswer {
            Product(it.getArgumentAt(0, Long::class.java))
        }
        Mockito.`when`(repository!!.save(Mockito.any<Menu>()))
                .thenReturn(Menu(1, dto.date, arrayListOf(
                        Meal(1, "Breakfast", "Don't use to much oil", 0, "",null,
                                arrayListOf(MealProduct(null, Product(1), 150),
                                        MealProduct(null, Product(2), 200))),
                        Meal(2, "Diner", "Chicken not burned", 0, "",null,
                                arrayListOf(MealProduct(null, Product(3), 50),
                                        MealProduct(null, Product(4), 300)))
                ), Patient(dto.patientId)))
        val menu = service!!.addMenu(dto)
        assertEquals(1, menu.id)
        assertEquals(dto.date, menu.date)
        assertEquals(dto.patientId, menu.patientId)
        for(i in 0..1) {
            assertEquals(dto.meals[i].comment, menu.meals[i].comment)
            assertEquals(dto.meals[i].name, menu.meals[i].name)
            assertEquals(dto.meals[i].extraInfo, menu.meals[i].extraInfo)
            assertEquals(dto.meals[i].score, menu.meals[i].score)


            for(j in menu.meals.indices) {
                assertEquals(dto.meals[i].mealProducts[j].productId, menu.meals[i].mealProducts[j].productId)
                assertEquals(dto.meals[i].mealProducts[j].quantity, menu.meals[i].mealProducts[j].quantity)
            }

        }
    }

    @Test
    fun testAddMenuProductDontExist() {
        val dto = MenuDto(0, 1, LocalDate.of(2018, 1, 25), listOf(
                MealDto(0, 0, "Breakfast", "Don't use to much oil", 0, "",
                        listOf(MealProductDto(150, 1), MealProductDto(200, 2))),
                MealDto(0, 0, "Diner", "Chicken not burned", 0, "",
                        listOf(MealProductDto(50, 3), MealProductDto(300, 4)))
        ))
        Mockito.`when`(patientRepo!!.findOne(Mockito.any())).thenAnswer {
            Patient(it.getArgumentAt(0, Long::class.java))
        }

        Mockito.`when`(productRepo!!.findOne(1)).thenThrow(InvalidDataAccessApiUsageException::class.java)
        try {
            service!!.addMenu(dto)
            fail("Must throw InvalidDataAccessApiUsageException when the patient not exist")
        } catch(ex: InvalidDataAccessApiUsageException) {}
    }

    @Test
    fun testDeleteWhenNotExsist() {
        Mockito.`when`(repository!!.delete(1)).thenThrow(EmptyResultDataAccessException::class.java)
        try {
            service!!.deleteMenu(1)
            fail("Must throw EmptyResultDataAccessException when the menu not exist")
        } catch(ex: EmptyResultDataAccessException) {}
    }

    @Test
    fun testDeleteSuccess() {
        service!!.deleteMenu(2)
    }
}