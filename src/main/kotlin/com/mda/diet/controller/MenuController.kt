package com.mda.diet.controller

import com.mda.diet.dto.MenuDto
import com.mda.diet.service.MenuService
import org.springframework.web.bind.annotation.*
import org.springframework.web.bind.MissingServletRequestParameterException




@RestController
@RequestMapping("$prefix/menu")
class MenuController(val service: MenuService) {

    @GetMapping("/{id}")
    fun getById(@PathVariable id: Long)
            = service.getById(id)

    @GetMapping("/patient/{id}")
    fun getByPatientId(@PathVariable id: Long)
            = service.getByPatientId(id)

    @GetMapping("/date")
    fun getByDate(@RequestParam(required = true) month: Int?,
                  @RequestParam(required = true) year: Int?,
                  @RequestParam(required = true) patientId: Long?)
            = service.getByDate(month!!, year!!, patientId!!)

    @PostMapping
    fun addMenu(@RequestBody menu: MenuDto)
            = service.addMenu(menu)

    @DeleteMapping("/{id}")
    fun deleteMenu(@PathVariable id: Long)
            = service.deleteMenu(id)

}
