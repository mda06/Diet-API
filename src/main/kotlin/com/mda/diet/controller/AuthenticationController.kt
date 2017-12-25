package com.mda.diet.controller

import com.mda.diet.dto.*
import com.mda.diet.service.AuthenticationService
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/auth")
class AuthenticationController(val service: AuthenticationService) {

    @PostMapping("/signup")
    fun signUp(@RequestBody signup: Auth0SignupAskDto)
        = service.signUp(signup)


    @PostMapping("/login")
    fun getToken(@RequestBody token: Auth0TokenAskDto)
        = service.getToken(token)

    @GetMapping("/connecteduser")
    fun getUser()
        = service.getUser()

    @GetMapping("/role")
    fun getRole()
        = service.getRole()


    @ExceptionHandler(IllegalArgumentException::class)
    @ResponseStatus(HttpStatus.FORBIDDEN)
    fun handleError(e: IllegalArgumentException) = e.message
}