package com.mda.diet.api.converter

import com.mda.diet.converter.GenderConverter
import com.mda.diet.model.Gender
import org.junit.Test
import org.junit.runner.RunWith
import org.springframework.test.context.junit4.SpringRunner
import kotlin.test.*

@RunWith(SpringRunner::class)
class GenderConverterTest {
    val converter = GenderConverter()

    @Test
    fun convertToDatabaseColumnShouldReturnF() {
        assertEquals("F", converter.convertToDatabaseColumn(Gender.FEMALE))
    }

    @Test
    fun convertToDatabaseColumnShouldReturnM() {
        assertEquals("M", converter.convertToDatabaseColumn(Gender.MALE))
    }

    @Test
    fun convertToDatabaseColumnShouldReturnO() {
        assertEquals("O", converter.convertToDatabaseColumn(Gender.OTHER))
    }

    @Test
    fun convertToEntityAttributeShouldReturnFemale() {
        assertEquals(Gender.FEMALE, converter.convertToEntityAttribute("F"))
    }

    @Test
    fun convertToEntityAttributeShouldReturnMale() {
        assertEquals(Gender.MALE, converter.convertToEntityAttribute("M"))
    }

    @Test
    fun convertToEntityAttributeShouldReturnOther() {
        assertEquals(Gender.OTHER, converter.convertToEntityAttribute("O"))
    }

    @Test
    fun convertToEntityAttributeShouldReturnOtherWhenElse() {
        assertEquals(Gender.OTHER, converter.convertToEntityAttribute("m"))
    }
}