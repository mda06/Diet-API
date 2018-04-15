package com.mda.diet.api.service

import com.mda.diet.error.UploadFileException
import com.mda.diet.model.Dietetist
import com.mda.diet.model.MealPicture
import com.mda.diet.model.Patient
import com.mda.diet.repository.CustomerRepository
import com.mda.diet.repository.MealPictureRepository
import com.mda.diet.service.PictureService
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.Mockito
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken
import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.test.context.junit4.SpringRunner
import kotlin.test.assertEquals
import kotlin.test.fail

@RunWith(SpringRunner::class)
class PictureServiceTest {

    init {
        System.setProperty("spring.config.name", "test")
        System.setProperty("spring.profiles.active", "test")
    }

    @Mock
    var repository: MealPictureRepository? = null

    @Mock
    var customerRepository: CustomerRepository? = null

    @InjectMocks
    var service: PictureService? = null

    @Test
    fun testGetMPMWhenPatientIdIsNotAPatient() {
        Mockito.`when`(customerRepository!!.findOne(1)).thenReturn(Dietetist())
        try {
            service!!.getMealPicturesModel(1)
            fail("Must throw UploadFileException when patientId is not from a Patient")
        } catch(ex: UploadFileException) {
            assertEquals("The id 1 is not a Patient !", ex.message)
        }
    }

    @Test
    fun testGetMPMWhenCurrentUserIsNotAPatient() {
        SecurityContextHolder.getContext().authentication =
                UsernamePasswordAuthenticationToken("", "")
        Mockito.`when`(customerRepository!!.getByAuthId("")).thenReturn(Dietetist())
        try {
            service!!.getMealPicturesModel(null)
            fail("Must throw UploadFileException when patientId is null and the current user is not a Patient")
        } catch(ex: UploadFileException) {
            assertEquals("The current customer is not a patient !", ex.message)
        }
    }

    @Test
    fun testGetMPMSuccess() {
        Mockito.`when`(customerRepository!!.findOne(3)).thenReturn(Patient(3))
        Mockito.`when`(repository!!.findByPatientId(3)).thenReturn(
                listOf(MealPicture(1), MealPicture(2))
        )
        val lst = service!!.getMealPicturesModel(3)
        assertEquals(1, lst[0].id)
        assertEquals(2, lst[1].id)
     }

}