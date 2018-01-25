package com.mda.diet.controller

import com.mda.diet.dto.MenuDto
import com.mda.diet.service.MenuService
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController


@RestController
@RequestMapping("$prefix/menu")
class MenuController(val service: MenuService) {

    @PostMapping
    fun addMenu(@RequestBody menu: MenuDto)
            = service.addMenu(menu)

}
