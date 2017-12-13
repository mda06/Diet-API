package com.mda.diet.controller

import org.springframework.beans.factory.annotation.Value
import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController


@RestController
@RequestMapping("/auth")
class AuthenticationController {

    @Value("\${auth0.client.id}")
    private val clientId: String? = null

    @Value("\${auth0.client.secret}")
    private val clientSecret: String? = null

    /*
    First create a customer
    Then put the user as post
    Add the return id of auth0 to the customer
    * */
    @PostMapping("/signup")
    fun signUp()
        = SecurityContextHolder.getContext().authentication.principal.toString()


    @PostMapping("/login")
    fun getToken()
        = "$clientId --- $clientSecret"
}