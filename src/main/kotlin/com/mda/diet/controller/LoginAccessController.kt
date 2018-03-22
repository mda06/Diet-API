package com.mda.diet.controller

import com.mda.diet.dto.LoginBlacklistDto
import com.mda.diet.service.LoginAccessService
import org.springframework.web.bind.annotation.*


@RestController
@RequestMapping("$prefix/login-access")
class LoginAccessController(val service: LoginAccessService) {

    @GetMapping()
    fun getAll()
            = service.getAll()

    @PostMapping("/blacklist/enable")
    fun blacklistLogin(@RequestBody blacklistDto: LoginBlacklistDto)
            = service.blacklistLogin(blacklistDto)

    @PostMapping("/blacklist/disable")
    fun unBlacklistLogin(@RequestBody blacklistDto: LoginBlacklistDto)
            = service.unBlacklistLogin(blacklistDto)

}