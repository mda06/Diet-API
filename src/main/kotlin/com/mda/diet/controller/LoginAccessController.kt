package com.mda.diet.controller

import com.mda.diet.service.LoginAccessService
import org.springframework.web.bind.annotation.*


@RestController
@RequestMapping("$prefix/login-access")
class LoginAccessController(val service: LoginAccessService) {

    @GetMapping()
    fun getAll()
            = service.getAll()

}