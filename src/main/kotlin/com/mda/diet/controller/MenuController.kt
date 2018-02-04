package com.mda.diet.controller

import com.mda.diet.dto.MenuDto
import com.mda.diet.service.MenuService
import org.springframework.format.annotation.DateTimeFormat
import org.springframework.web.bind.annotation.*
import java.time.LocalDate


@RestController
@RequestMapping("$prefix/menu")
class MenuController(val service: MenuService) {

    @GetMapping("/{id}")
    fun getById(@PathVariable id: Long)
            = service.getById(id)

    @GetMapping("/patient/{id}")
    fun getByPatientId(@PathVariable id: Long)
            = service.getByPatientId(id)

    @GetMapping("/date/{date}")
    fun getByDate(@PathVariable @DateTimeFormat(pattern="yyyy-MM-dd") date: LocalDate,
                  @RequestParam(required = true) patientId: Long)
            = service.getByDate(date, patientId)

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
