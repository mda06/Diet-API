package com.mda.diet.api

import com.mda.diet.controller.AddressController
import org.junit.Test
import org.junit.runner.RunWith
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.junit4.SpringRunner
import org.springframework.http.HttpStatus
import com.mda.diet.error.ApiError
import com.mda.diet.model.Address
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.web.client.TestRestTemplate
import org.springframework.http.HttpHeaders
import org.springframework.web.client.RestTemplate
import kotlin.test.*


@RunWith(SpringRunner::class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class ApiApplicationTests {

	@Test
	fun contextLoads() {

	}
	/*@Autowired
	lateinit var testRestTemplate: TestRestTemplate


	@Test
	fun whenMethodArgumentMismatchThenBadRequest() {
		//Temporary code
		val ret = testRestTemplate.getForEntity("/api/address/1", Address::class.java)
		println(ret)
		assertEquals(HttpStatus.OK, ret.statusCode)
		assertTrue(ret.body.city.contains("should be of type"))
	}*/
}
