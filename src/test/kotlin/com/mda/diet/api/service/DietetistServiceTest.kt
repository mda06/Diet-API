package com.mda.diet.api.service


import com.mda.diet.dto.DietetistAttachPatientDto
import com.mda.diet.error.CustomNotFoundException
import org.junit.Test
import org.junit.runner.RunWith
import com.mda.diet.model.Dietetist
import com.mda.diet.model.Patient
import com.mda.diet.repository.DietetistRepository
import com.mda.diet.repository.PatientRepository
import com.mda.diet.service.DietetistService
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.Mockito
import org.springframework.test.context.junit4.SpringRunner
import kotlin.test.*


@RunWith(SpringRunner::class)
class DietetistServiceTest {

    init {
        System.setProperty("spring.config.name", "test")
        System.setProperty("spring.profiles.active", "test")
    }

    @Mock
    var repository: DietetistRepository? = null

    @Mock
    var patientRepository: PatientRepository? = null

    @InjectMocks
    var service: DietetistService? = null

    @Test
    fun testFindDietetistShouldPass() {
        val dietIn = Dietetist(1, "Maurine", "", "Coppens")
        Mockito.`when`(repository!!.findOne(1)).thenReturn(dietIn)
        val diet = service!!.getById(1)
        assertEquals(1, diet.id)
        assertEquals("Maurine", diet.firstName)
        assertEquals("", diet.middleName)
        assertEquals("Coppens", diet.lastName)
    }

    @Test
    fun testNotDietetistShouldThrowError() {
        try {
            service!!.getById(2)
        } catch(ex: CustomNotFoundException) {
            assertEquals("Not found dietetist with id 2", ex.message!!)
        }
    }

    @Test
    fun testGetAllShouldReturnCorrectNumber() {
        Mockito.`when`(repository!!.findAll()).thenReturn(listOf(Dietetist(), Dietetist(), Dietetist()))
        val nb = service!!.findAll().count()
        assertEquals(3, nb)
    }


    @Test
    fun testAttachWhenEverythingIsOkShouldReturnGood() {
        Mockito.`when`(repository!!.findOne(2)).thenReturn(Dietetist(2)
                .also { it.patients.add(0, Patient().also { it.dietetistId = 2 }) })
        Mockito.`when`(patientRepository!!.findOne(4)).thenReturn(Patient(4))
        val diet = service!!.attachPatient(DietetistAttachPatientDto(4, 2))
        if(diet.patients.stream().anyMatch { it -> it.dietetistId == 2L })
            return
        else
            fail("No patient with id 2 is attached to the diet")
    }

    @Test
    fun testAttachWhenPatientIdIsNotGoodShouldReturnException() {
        Mockito.`when`(repository!!.findOne(2)).thenReturn(Dietetist(2))
        Mockito.`when`(patientRepository!!.findOne(4)).thenReturn(null)
        try {
            service!!.attachPatient(DietetistAttachPatientDto(4, 2))
            fail("Should return exception when patient is null")
        } catch (ex: CustomNotFoundException) {
            assertEquals("Not found patient or dietetist with id 4", ex.message)
        }
    }

    @Test
    fun testAttachWhenDietIdIsNotGoodShouldReturnException() {
        Mockito.`when`(repository!!.findOne(2)).thenReturn(null)
        Mockito.`when`(patientRepository!!.findOne(4)).thenReturn(Patient(4))
        try {
            service!!.attachPatient(DietetistAttachPatientDto(4, 2))
            fail("Should return exception when diet is null")
        } catch (ex: CustomNotFoundException) {
            assertEquals("Not found patient or dietetist with id 4", ex.message)
        }
    }

}
