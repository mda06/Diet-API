package com.mda.diet.controller

import com.mda.diet.model.Auth0TokenAsk
import com.mda.diet.model.Auth0TokenReturn
import org.springframework.beans.factory.annotation.Value
import org.springframework.core.ParameterizedTypeReference
import org.springframework.http.HttpMethod
import org.springframework.http.HttpStatus
import org.springframework.http.RequestEntity
import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.web.bind.annotation.*
import org.springframework.web.client.HttpClientErrorException
import org.springframework.web.client.RestTemplate
import java.net.URI


@RestController
@RequestMapping("/auth")
class AuthenticationController {

    @Value("\${auth0.client.id}")
    private val clientId: String? = null

    @Value("\${auth0.client.secret}")
    private val clientSecret: String? = null

    @Value("\${auth0.audience}")
    private val audience: String? = null

    /*
    First create a customer
    Then put the user as post
    Add the return id of auth0 to the customer
    * */
    @PostMapping("/signup")
    fun signUp()
        = SecurityContextHolder.getContext().authentication.principal.toString()


    @PostMapping("/login")
    fun getToken(@RequestBody token: Auth0TokenAsk) : Auth0TokenReturn {
        token.audience = audience
        token.client_id = clientId
        token.client_secret = clientSecret
        token.grant_type = "password"
        token.scope = "openid"

        val rest = RestTemplate()
        try {
            return rest.postForObject("https://mdatest.eu.auth0.com/oauth/token", token, Auth0TokenReturn::class.java)
        } catch (ex: HttpClientErrorException) {
            throw IllegalArgumentException(ex.message)
        }
    }

    @ExceptionHandler(IllegalArgumentException::class)
    @ResponseStatus(HttpStatus.FORBIDDEN)
    fun handleError(e: IllegalArgumentException) = e.message
}