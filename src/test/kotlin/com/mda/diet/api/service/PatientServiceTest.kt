package com.mda.diet.api.service


import com.mda.diet.error.CustomNotFoundException
import com.mda.diet.model.*
import org.junit.Test
import org.junit.runner.RunWith
import com.mda.diet.repository.AnthropometricParameterRepository
import com.mda.diet.repository.CustomerRepository
import com.mda.diet.repository.PatientRepository
import com.mda.diet.service.PatientService
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.Matchers.*
import org.mockito.Mockito
import org.springframework.test.context.junit4.SpringRunner
import java.util.function.Consumer
import kotlin.test.*


@RunWith(SpringRunner::class)
class PatientServiceTest {

    @Mock
    var repository: PatientRepository? = null

    @Mock
    var customerRepository: CustomerRepository? = null

    @Mock
    var paramRepository: AnthropometricParameterRepository? = null

    @InjectMocks
    var service: PatientService? = null

    @Test
    fun testFindPatientShouldPass() {
        val patIn = Patient(1, "Mika", "", "VM", "", "", Address(),
                Gender.MALE, null, null, "", null, mutableListOf())
        Mockito.`when`(repository!!.findOne(1)).thenReturn(patIn)
        val pat = service!!.getById(1)
        assertEquals(1, pat.id)
        assertEquals("Mika", pat.firstName)
        assertEquals("VM", pat.lastName)
        assertEquals(Gender.MALE, pat.gender)
    }

    @Test
    fun testNotPatientShouldThrowError() {
        try {
            service!!.getById(2)
        } catch(ex: CustomNotFoundException) {
            assertEquals("Not found patient with id 2", ex.message!!)
        }
    }

    @Test
    fun testGetAllShouldReturnCorrectNumber() {
        Mockito.`when`(repository!!.findAll()).thenReturn(listOf(Patient(), Patient(), Patient()))
        val nb = service!!.findAll().count()
        assertEquals(3, nb)
    }

    @Test
    fun testAddPatientWhenDietetistIdIsZero() {
        val patIn = Patient(1, "Mika", "", "VM", "", "", Address(),
                Gender.MALE, null, null, "", 0, mutableListOf())
        Mockito.`when`(customerRepository!!.getByAuthId(anyString())).thenReturn(Dietetist(2))
        Mockito.`when`(repository!!.save(patIn)).thenReturn(patIn)
        val pat = service!!.addPatient(patIn)
        assertEquals(1, pat.id)
        assertEquals(2, pat.dietetistId)
    }

    @Test
    fun testAddPatientWhenPatientIdIsZero() {
        val p1 = AnthropometricParameter()
        val p2 = AnthropometricParameter()
        val patIn = Patient(0, "Mika", "", "VM", "", "", Address(),
                Gender.MALE, null, null, "", 2,
                mutableListOf(p1, p2))
        Mockito.`when`(repository!!.save(patIn)).thenReturn(patIn.also { it.id = 2 })
        Mockito.`when`(paramRepository!!.save(p1)).thenReturn(p1.also { it.patientId = 2 })
        Mockito.`when`(paramRepository!!.save(p2)).thenReturn(p2.also { it.patientId = 2 })
        val pat = service!!.addPatient(patIn)
        assertEquals(2, pat.id, "Id")
        assertEquals(2, pat.anthropometricParameters.count(), "Count")
        pat.anthropometricParameters.forEach(Consumer {
            assertEquals(2, it.patientId, "Param")
        })
    }

    @Test
    fun testAddPatientWhenPatientIdIsNotZero() {
        val patIn = Patient(1, "Mika", "", "VM", "", "", Address(),
                Gender.MALE, null, null, "", 2, mutableListOf())
        Mockito.`when`(repository!!.save(patIn)).thenReturn(patIn)
        val pat = service!!.addPatient(patIn)
        assertEquals(1, pat.id)
        assertEquals(2, pat.dietetistId)
        assertEquals(0, pat.anthropometricParameters.count())
    }
}
