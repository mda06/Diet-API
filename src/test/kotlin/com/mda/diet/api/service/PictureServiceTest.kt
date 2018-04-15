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
import org.springframework.mock.web.MockMultipartFile
import java.time.LocalDate
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

    @Test
    fun testUploadWhenDateIsNull() {
        try {
            service!!.handleFileUpload(listOf(), null)
            fail("Must throw UploadFileException when the date is null")
        } catch(ex: UploadFileException) {
            assertEquals("No date was given", ex.message)
        }
    }

    @Test
    fun testUploadWhenPicturesIsEmpty() {
        try {
            service!!.handleFileUpload(listOf(), LocalDate.now())
            fail("Must throw UploadFileException when the pictures are empty")
        } catch(ex: UploadFileException) {
            assertEquals("No pictures was given", ex.message)
        }
    }

    @Test
    fun testUploadWhenCustomerIsNotAPatient() {
        SecurityContextHolder.getContext().authentication =
                UsernamePasswordAuthenticationToken("", "")
        Mockito.`when`(customerRepository!!.getByAuthId("")).thenReturn(Dietetist())

        try {
            service!!.handleFileUpload(listOf(MockMultipartFile("file", "orig", null, "bar".toByteArray())), LocalDate.now())
            fail("Must throw UploadFileException when the current user is not a Patient")
        } catch(ex: UploadFileException) {
            assertEquals("The current customer is not a patient !", ex.message)
        }
    }

    @Test
    fun testUploadWhenFilenameAlreadyExists() {
        SecurityContextHolder.getContext().authentication =
                UsernamePasswordAuthenticationToken("", "")
        Mockito.`when`(customerRepository!!.getByAuthId("")).thenReturn(Patient(1))
        Mockito.`when`(repository!!.existsByFilenameInAndPatientIdIs(
                listOf("hello.jpg", "name.png", "food.png"), 1)).thenReturn(true)

        try {
            service!!.handleFileUpload(listOf(
                    MockMultipartFile("hello.jpg", "hello.jpg", null, "bar".toByteArray()),
                    MockMultipartFile("name.png", "name.png", null, "bar".toByteArray()),
                    MockMultipartFile("food.png", "food.png", null, "bar".toByteArray())
            ), LocalDate.now())
            fail("Must throw UploadFileException when a filename already exist")
        } catch(ex: UploadFileException) {
            assertEquals("There already a file named like this", ex.message)
        }
    }
}