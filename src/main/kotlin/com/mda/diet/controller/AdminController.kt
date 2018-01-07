package com.mda.diet.controller

import com.mda.diet.model.Admin
import com.mda.diet.service.AdminService
import org.springframework.web.bind.annotation.*


@RestController
@RequestMapping("$prefix/admin")
class AdminController(val service: AdminService) {

    @GetMapping
    fun findAll() = service.findAll()

    @PostMapping
    fun addAdmin(@RequestBody admin: Admin)
            = service.addAdmin(admin)

    @PutMapping("/{id}")
    fun updateAdmin(@PathVariable id: Long, @RequestBody admin: Admin)
            = service.updateAdmin(id, admin)

    @DeleteMapping("/{id}")
    fun deleteAddress(@PathVariable id: Long)
            = service.deleteAddress(id)

    @GetMapping("/{id}")
    fun getById(@PathVariable id: Long)
            = service.getById(id)
}