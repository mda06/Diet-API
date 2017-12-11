package com.mda.diet.controller

import com.mda.diet.model.Admin
import com.mda.diet.repository.AdminRepository
import org.springframework.web.bind.annotation.*


@RestController
@RequestMapping("/admin")
class AdminController(val repository: AdminRepository) {

    @GetMapping
    fun findAll() = repository.findAll()

    @PostMapping
    fun addAdmin(@RequestBody admin: Admin)
            = repository.save(admin)

    @PutMapping("/{id}")
    fun updateAdmin(@PathVariable id: Long, @RequestBody admin: Admin) : Admin {
        assert(id == admin.id)
        return repository.save(admin)
    }

    @DeleteMapping("/{id}")
    fun deleteAddress(@PathVariable id: Long)
            = repository.delete(id)

    @GetMapping("/{id}")
    fun getById(@PathVariable id: Long)
            = repository.findOne(id)
}