package com.mda.diet.api.service


import com.mda.diet.error.CustomNotFoundException
import org.junit.Test
import org.junit.runner.RunWith
import com.mda.diet.model.AnthropometricParameter
import com.mda.diet.repository.AnthropometricParameterRepository
import com.mda.diet.service.AnthropometricParameterService
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.Mockito
import org.springframework.test.context.junit4.SpringRunner
import kotlin.test.*


@RunWith(SpringRunner::class)
class AnthropometricParameterServiceTest {

    init {
        System.setProperty("spring.config.name", "test")
        System.setProperty("spring.profiles.active", "test")
    }

    @Mock
    var repository: AnthropometricParameterRepository? = null

    @InjectMocks
    var service: AnthropometricParameterService? = null

    @Test
    fun testFindAnthropometricParameterShouldPass() {
        val paramIn = AnthropometricParameter(1, 180, 80.0, 4.5)
        Mockito.`when`(repository!!.findOne(1)).thenReturn(paramIn)
        val param = service!!.getById(1)
        assertEquals(1, param.id)
        assertEquals(180, param.length)
        assertEquals(80.0, param.weight)
        assertEquals(4.5, param.bodyFat)
    }

    @Test
    fun testNotAnthropometricParameterShouldThrowError() {
        try {
            service!!.getById(2)
        } catch(ex: CustomNotFoundException) {
            assertEquals("Not found param with id 2", ex.message!!)
        }
    }

    @Test
    fun testGetAllShouldReturnCorrectNumber() {
        Mockito.`when`(repository!!.findAll()).thenReturn(listOf(AnthropometricParameter(), AnthropometricParameter(),
                AnthropometricParameter()))
        val nb = service!!.findAll().count()
        assertEquals(3, nb)
    }

    @Test
    fun testGetByPatientIdShouldReturnCorrectNumber() {
        Mockito.`when`(repository!!.getAllByPatientId(1)).thenReturn(listOf(AnthropometricParameter(), AnthropometricParameter(),
                AnthropometricParameter()))
        val nb = service!!.getByPatient(1).count()
        assertEquals(3, nb)
    }

    @Test
    fun testGetByPatientIdShouldThrowError() {
        Mockito.`when`(repository!!.getAllByPatientId(2)).thenReturn(listOf())
        try {
            service!!.getByPatient(2).count()
            fail("Must throw exception when no params are found for patient id")
        } catch(ex: CustomNotFoundException) {
            assertEquals("Not found param with patientid 2", ex.message!!)
        }
    }
}
