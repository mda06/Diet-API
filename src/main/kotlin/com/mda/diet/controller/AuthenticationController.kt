package com.mda.diet.controller

import com.mda.diet.model.*
import com.mda.diet.repository.CustomerRepository
import org.springframework.beans.factory.annotation.Value
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*
import org.springframework.web.client.HttpClientErrorException
import org.springframework.web.client.RestTemplate


@RestController
@RequestMapping("/auth")
class AuthenticationController(val repository: CustomerRepository) {

    @Value("\${auth0.client.id}")
    private val clientId: String? = null

    @Value("\${auth0.client.secret}")
    private val clientSecret: String? = null

    @Value("\${auth0.audience}")
    private val audience: String? = null

    @Value("\${auth0.issuer}")
    private val issuer: String? = null

    //Get the current id that has been authenticated
    //SecurityContextHolder.getContext().authentication.principal.toString()

    @PostMapping("/signup")
    fun signUp(@RequestBody signup: Auth0SignupAsk) : Auth0SignupReturn {
        signup.client_id = clientId
        signup.connection = "Username-Password-Authentication"
        val customer = repository.getById(signup.customerId)

        val rest = RestTemplate()
        try {
            val signupReturn = rest.postForObject("${issuer}dbconnections/signup", signup, Auth0SignupReturn::class.java)
            customer.authId = signupReturn._id
            repository.save(customer)
            return signupReturn
        } catch (ex: HttpClientErrorException) {
            throw IllegalArgumentException(ex.message)
        }
    }


    @PostMapping("/login")
    fun getToken(@RequestBody token: Auth0TokenAsk) : Auth0TokenReturn {
        token.audience = audience
        token.client_id = clientId
        token.client_secret = clientSecret
        token.grant_type = "password"
        token.scope = "openid"

        val rest = RestTemplate()
        try {
            return rest.postForObject("${issuer}oauth/token", token, Auth0TokenReturn::class.java)
        } catch (ex: HttpClientErrorException) {
            throw IllegalArgumentException(ex.message)
        }
    }

    @ExceptionHandler(IllegalArgumentException::class)
    @ResponseStatus(HttpStatus.FORBIDDEN)
    fun handleError(e: IllegalArgumentException) = e.message
}