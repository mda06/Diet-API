package com.mda.diet.api.controller

import com.fasterxml.jackson.databind.ObjectMapper
import com.mda.diet.error.CustomNotFoundException
import com.mda.diet.model.Address
import com.mda.diet.service.AddressService
import org.junit.BeforeClass
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Matchers.any
import org.mockito.Matchers.anyObject
import org.mockito.Mockito
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.mock.mockito.MockBean
import org.springframework.boot.test.web.client.TestRestTemplate
import org.springframework.http.HttpEntity
import org.springframework.http.HttpHeaders
import org.springframework.http.HttpMethod
import org.springframework.http.HttpStatus
import org.springframework.test.context.junit4.SpringRunner
import kotlin.test.assertEquals


@RunWith(SpringRunner::class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class AddressControllerTest {
    companion object {
        val headers = HttpHeaders()
        @JvmStatic
        @BeforeClass
        fun init() {
            //TODO change this with a request to /auth/login ? Store in a file ?
            headers.add("Authorization", "Bearer eyJ0eXAiOiJKV1QiLCJhbGciOiJSUzI1NiIsImtpZCI6Ik56ZzRNVUZGUkRRelFUTTBNVVUxUlRJME1USkVPVEUyUlRNMlJVVkNNREJFTWpRNE9Ua3lSQSJ9.eyJpc3MiOiJodHRwczovL21kYXRlc3QuZXUuYXV0aDAuY29tLyIsInN1YiI6ImF1dGgwfDVhMzhkZDgzOGQzY2VhN2FhZDQwZTVhZCIsImF1ZCI6WyJodHRwczovL2RpZXQtbWFuYWdlbWVudC5jb20iLCJodHRwczovL21kYXRlc3QuZXUuYXV0aDAuY29tL3VzZXJpbmZvIl0sImlhdCI6MTUxNTE0NzAzNiwiZXhwIjoxNTE1MjMzNDM2LCJhenAiOiI1bm5SWFVpV3F4OWNNUzY1b0FOV01hUDN4ZUUxNlZBMSIsInNjb3BlIjoib3BlbmlkIHByb2ZpbGUgZW1haWwgYWRkcmVzcyBwaG9uZSIsImd0eSI6InBhc3N3b3JkIn0.NS5a4TCxu9z8j2QT0_Bsz1YpOTwOkPLvkomCM5ELblALNxb5X_7dzliCp0arCqLUEbj8yVvMCx_EU-npz7-LX9Vca13oenvHEGuD6jLMN2RiireCxWx1ZZPKaklZ0hzybtdP_TlBxgLI2YZU8_POOkDCbHnZeRzXF-t8EgO5mmmKL42BXdb6HyVs5Dbxas-9nRBBTf0s2qEYTfg1FGzdjXRahVRKB3ZbPK0XRchrlaRI7WpOJ7kIBXatgl3JpjDDZG9DSziVSXxNKlAOUOmawgdb9hCRrV-AvKY0x6dHOSaTczTGmwbsIyQvx6KUnWSbkhFhNpUDZ3S9z8CjnoOi1A")
            headers.add("Content-Type", "application/json")
        }

    }

    @Autowired
    lateinit var testRestTemplate: TestRestTemplate

    @MockBean
    private var service: AddressService? = null

    @Test
    fun whenGetAddressShouldReturnGoodAddress() {
        val adrIn = Address(1, "Belgium", 1080, "Brussels", "Vandernoot", "37")
        Mockito.`when`(service!!.getById(1)).thenReturn(adrIn)
        val request = HttpEntity<Address>(headers)
        val response = testRestTemplate.exchange("/address/1", HttpMethod.GET, request, Address::class.java)
        assertEquals(HttpStatus.OK, response.statusCode)
        assertEquals(adrIn.id, response.body.id)
        assertEquals(adrIn.country, response.body.country)
        assertEquals(adrIn.postcode, response.body.postcode)
        assertEquals(adrIn.city, response.body.city)
        assertEquals(adrIn.street, response.body.street)
        assertEquals(adrIn.number, response.body.number)
    }

    @Test
    fun whenGetAddressShouldReturnException() {
        Mockito.`when`(service!!.getById(1)).thenThrow(CustomNotFoundException(""))
        val request = HttpEntity<Any>(headers)
        val response = testRestTemplate.exchange("/address/1", HttpMethod.GET, request, Address::class.java)
        assertEquals(HttpStatus.NOT_FOUND, response.statusCode)
    }

    /*@Test
    fun whenPostAddressShouldReturnAddress() {
        val adrIn = Address(1, "Belgium", 1080, "Brussels", "Vandernoot", "37")
        Mockito.`when`(service!!.addAddress(adrIn)).thenReturn(adrIn)
        val request = HttpEntity<Address>(adrIn, headers)
        val response = testRestTemplate.postForEntity("/address", request, Address::class.java)
        assertEquals(HttpStatus.OK, response.statusCode)
        assertEquals(adrIn.id, response.body.id)
        assertEquals(adrIn.country, response.body.country)
        assertEquals(adrIn.postcode, response.body.postcode)
        assertEquals(adrIn.city, response.body.city)
        assertEquals(adrIn.street, response.body.street)
        assertEquals(adrIn.number, response.body.number)
    }*/
}