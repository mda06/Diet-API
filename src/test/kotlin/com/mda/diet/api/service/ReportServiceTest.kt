package com.mda.diet.api.service

import com.mda.diet.dto.MealDto
import com.mda.diet.dto.MealProductDto
import com.mda.diet.dto.MenuDto
import com.mda.diet.error.CustomNotFoundException
import com.mda.diet.model.*
import com.mda.diet.repository.MenuRepository
import com.mda.diet.service.ReportService
import org.junit.Assert
import org.junit.Test
import org.junit.runner.RunWith
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
class ReportServiceTest {

    init {
        System.setProperty("spring.config.name", "test")
        System.setProperty("spring.profiles.active", "test")
    }

    @Mock
    var repository: MenuRepository? = null

    @InjectMocks
    var service: ReportService? = null

    @Test
    fun testGetMenuReportWhenMenuNotExist() {
        Mockito.`when`(repository!!.findOne(1)).thenReturn(null)
        try {
            service!!.getMenuReport(1, "fr")
            fail("Must throw CustomNotFoundException when the menu not exist")
        } catch(ex: CustomNotFoundException) {
            assertEquals("Not found menu with id 1", ex.message)
        }
    }

    @Test
    fun testGetMenuReportWhenProductLanguageNotExist() {
        Mockito.`when`(repository!!.findOne(1)).thenReturn(Menu(1, null, mutableListOf(
                Meal(1, "Dinner", "", 0, "", null, mutableListOf(
                        MealProduct(1, null, Product(1, "", mutableListOf(
                                ProductTranslation(1, "en", "", 0)
                        )), 0)
                ))
        )))
        try {
            service!!.getMenuReport(1, "fr")
            fail("Must throw CustomNotFoundException when the product language not exist")
        } catch(ex: CustomNotFoundException) {
            assertEquals("Not found product in fr", ex.message)
        }
    }

    @Test
    fun testGetMenuReportWithOneProduct() {
        Mockito.`when`(repository!!.findOne(1)).thenReturn(Menu(1, null, mutableListOf(
                Meal(1, "Dinner", "", 0, "", null, mutableListOf(
                        MealProduct(1, null, createProduct(), 50)
                ))
        )))
        val dto = service!!.getMenuReport(1, "en")
        Assert.assertEquals(6.5, dto.macros[0].value, 1.0)
        Assert.assertEquals(56.5, dto.macros[1].value, 1.0)
        Assert.assertEquals(100.5, dto.macros[2].value, 1.0)
        Assert.assertEquals(21.5, dto.micros[0].value, 1.0)
        Assert.assertEquals(6.5, dto.micros[1].value, 1.0)
        Assert.assertEquals(10.0, dto.micros[2].value, 1.0)
    }

    @Test
    fun testGetMenuReportWith2Products() {
        Mockito.`when`(repository!!.findOne(1)).thenReturn(Menu(1, null, mutableListOf(
                Meal(1, "Dinner", "", 0, "", null, mutableListOf(
                        MealProduct(1, null, createProduct(), 50),
                        MealProduct(1, null, createProduct(), 50)
                ))
        )))
        val dto = service!!.getMenuReport(1, "en")
        Assert.assertEquals(13.0, dto.macros[0].value, 1.0)
        Assert.assertEquals(113.0, dto.macros[1].value, 1.0)
        Assert.assertEquals(201.0, dto.macros[2].value, 1.0)
        Assert.assertEquals(43.0, dto.micros[0].value, 1.0)
        Assert.assertEquals(13.0, dto.micros[1].value, 1.0)
        Assert.assertEquals(20.0, dto.micros[2].value, 1.0)
    }

    @Test
    fun testGetMenuReportWith2OtherProducts() {
        Mockito.`when`(repository!!.findOne(1)).thenReturn(Menu(1, null, mutableListOf(
                Meal(1, "Dinner", "", 0, "", null, mutableListOf(
                        MealProduct(1, null, createProduct(), 50),
                        MealProduct(1, null, createSecondProduct(), 150)
                ))
        )))
        val dto = service!!.getMenuReport(1, "en")

        Assert.assertEquals(84.15, dto.macros[0].value, 1.0)
        Assert.assertEquals(269.0, dto.macros[1].value, 1.0)
        Assert.assertEquals(56.50, dto.macros[2].value, 1.0)
        Assert.assertEquals(100.50, dto.macros[3].value, 1.0)

        Assert.assertEquals(55.7, dto.micros[0].value, 1.0)
        Assert.assertEquals(117.45, dto.micros[1].value, 1.0)
        Assert.assertEquals(60.8, dto.micros[2].value, 1.0)
        Assert.assertEquals(50.5, dto.micros[3].value, 1.0)
    }

    fun createProduct() : Product {
        return Product(1, "", mutableListOf(
                ProductTranslation(1, "en", "", 1, mutableListOf(),
                        //Macros
                        mutableListOf(
                                Nutriment(0, "Fibres", 13.0, "mg"),
                                Nutriment(0, "Energie", 113.0, "kcal"),
                                Nutriment(0, "Sugars", 201.0, "kcal")),
                        //Micros
                        mutableListOf(
                                Nutriment(0, "Water", 43.0, "ml"),
                                Nutriment(0, "B12", 13.0, "mg"),
                                Nutriment(0, "Vitamine", 20.0, "mg"))
                        ))
        )
    }

    fun createSecondProduct() : Product {
        return Product(1, "", mutableListOf(
                ProductTranslation(1, "en", "", 1, mutableListOf(),
                        //Macros
                        mutableListOf(
                                Nutriment(0, "Fibres", 175.0, "mg"),
                                Nutriment(0, "Proteins", 56.1, "kcal")),
                        //Micros
                        mutableListOf(
                                Nutriment(0, "Water", 22.8, "ml"),
                                Nutriment(0, "B12", 36.2, "mg"),
                                Nutriment(0, "Stratch", 78.3, "mg"),
                                Nutriment(0, "Vitamine", 27.0, "mg"))
                ))
        )
    }

}