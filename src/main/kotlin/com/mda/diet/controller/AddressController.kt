package com.mda.diet.controller

import com.mda.diet.model.Address
import com.mda.diet.repository.AddressRepository
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/address")
class AddressController(val repository: AddressRepository) {

    @GetMapping
    fun findAll() = repository.findAll()

    @PostMapping
    fun addAddress(@RequestBody address: Address)
            = repository.save(address)

    @PutMapping("/{id}")
    fun updateAddress(@PathVariable id: Long, @RequestBody address: Address) {
        assert(id == address.id)
        repository.save(address)
    }

    @DeleteMapping("/{id}")
    fun deleteAddress(@PathVariable id: Long)
            = repository.delete(id)

    @GetMapping("/{id}")
    fun getById(@PathVariable id: Long)
            = repository.findOne(id)
}