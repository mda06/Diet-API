package com.mda.diet.api.controller

import com.mda.diet.controller.AddressController
import com.mda.diet.controller.TestController
import com.mda.diet.dto.Auth0TokenReturnDto
import com.mda.diet.model.Address
import com.mda.diet.service.AddressService
import org.assertj.core.api.Assertions.assertThat
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get
import org.springframework.test.web.servlet.result.MockMvcResultHandlers.print
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.content
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.status

import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mockito
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.mock.mockito.MockBean
import org.springframework.boot.test.web.client.TestRestTemplate
import org.springframework.http.HttpStatus
import org.springframework.test.context.junit4.SpringRunner
import org.springframework.test.web.servlet.MockMvc
import kotlin.test.assertEquals
import kotlin.test.assertTrue
import org.springframework.boot.context.embedded.LocalServerPort
import org.springframework.http.HttpEntity
import org.springframework.http.HttpHeaders
import org.springframework.http.HttpMethod
import org.springframework.http.ResponseEntity




@RunWith(SpringRunner::class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class ControllerTest {

    @Autowired
    lateinit var testRestTemplate: TestRestTemplate


    @LocalServerPort
    private val port: Int = 0


    @Test
    fun whenMethodArgumentMismatchThenBadRequest() {
        val headers = HttpHeaders()
        headers.add("Authorization", "Bearer eyJ0eXAiOiJKV1QiLCJhbGciOiJSUzI1NiIsImtpZCI6Ik56ZzRNVUZGUkRRelFUTTBNVVUxUlRJME1USkVPVEUyUlRNMlJVVkNNREJFTWpRNE9Ua3lSQSJ9.eyJpc3MiOiJodHRwczovL21kYXRlc3QuZXUuYXV0aDAuY29tLyIsInN1YiI6ImF1dGgwfDVhMzhkZDgzOGQzY2VhN2FhZDQwZTVhZCIsImF1ZCI6WyJodHRwczovL2RpZXQtbWFuYWdlbWVudC5jb20iLCJodHRwczovL21kYXRlc3QuZXUuYXV0aDAuY29tL3VzZXJpbmZvIl0sImlhdCI6MTUxNTA1OTg5NiwiZXhwIjoxNTE1MTQ2Mjk2LCJhenAiOiI1bm5SWFVpV3F4OWNNUzY1b0FOV01hUDN4ZUUxNlZBMSIsInNjb3BlIjoib3BlbmlkIHByb2ZpbGUgZW1haWwgYWRkcmVzcyBwaG9uZSIsImd0eSI6InBhc3N3b3JkIn0.Qq_GcRoSp_KfTpJV55WBEbRSppTEhTOt5jw9tiTr5LR0cHhGcuWwTBcW9Hu159NypzERxE4EIPpFJrxgHgbDb6UCDkDBtDSVEjssJA3dO0f5cbjR5hITEOX3fXFW-A0NDqfgIu3X4ceMSePvdq9Fy2_KpwcoqZa0Fts6Y2ktIAs2b_xllJ60L595wgNlwdpL9Bd5Sx6_uemxhz5NZZCr-YCz22hHngtbLbK_ACim4RE3F8WT_u_AQtFJVmb4MS_HMcvMw1cArQLN3O6kyidxngENP8jlHq_9NIUY35Sj-yYhW2ZwcjzEZvsX0u1DEG74Qh97Ky3a0q37LwwMD3_jcQ")

        //val ret = testRestTemplate.exchange("http://localhost:$port/api/auth/login", HttpMethod.GET, HttpEntity<String>(headers), String::class.java)
        //println(ret)
        //Temporary code
        val ret = testRestTemplate.getForObject("/testy", String::class.java, headers)
        println(ret)
        //assertEquals(HttpStatus.OK, ret.statusCode)

        val request = HttpEntity<String>(headers)
        val response = testRestTemplate.exchange("/testy", HttpMethod.GET, request, String::class.java)
        println(response)
    }
    //@MockBean
    //private var adrService: AddressService? = null
}