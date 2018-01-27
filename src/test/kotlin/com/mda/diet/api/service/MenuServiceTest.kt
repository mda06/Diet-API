package com.mda.diet.api.service

import com.mda.diet.dto.MealDto
import com.mda.diet.dto.MenuDto
import com.mda.diet.error.CustomNotFoundException
import com.mda.diet.model.Meal
import com.mda.diet.model.Menu
import com.mda.diet.model.Patient
import com.mda.diet.model.Product
import com.mda.diet.repository.MenuRepository
import com.mda.diet.repository.PatientRepository
import com.mda.diet.repository.ProductRepository
import com.mda.diet.service.MenuService
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.Mockito
import org.springframework.dao.EmptyResultDataAccessException
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
        /*val dto = MenuDto(0, 1, LocalDate.of(2018, 1, 25), listOf(
                MealDto(0, "Breakfast", "Don't use to much oil", 0, "",
                        listOf(1, 2)),
                MealDto(0, "Diner", "Chicken not burned", 0, "",
                        listOf(3, 4))
        ))
        Mockito.`when`(patientRepo!!.findOne(1)).thenReturn(Patient(1))
        Mockito.`when`(productRepo!!.findAll(listOf(1L, 2L))).thenReturn(listOf(Product(1), Product(2)))
        Mockito.`when`(productRepo!!.findAll(listOf(3L, 4L))).thenReturn(listOf(Product(3)))
        Mockito.`when`(repository!!.save(Mockito.any<Menu>()))
                .thenReturn(Menu(1, dto.date, arrayListOf(
                        Meal(1, "Breakfast", "Don't use to much oil", 0, "",null,
                                arrayListOf(Product(1), Product(2))),
                        Meal(2, "Diner", "Chicken not burned", 0, "",null,
                                arrayListOf(Product(3), Product(4)))
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
            assertEquals(dto.meals[i].productIds[i], menu.meals[i].productIds[i])
            assertEquals(dto.meals[i].productIds[1], menu.meals[i].productIds[1])
        }*/
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