package com.mda.diet.controller

import com.mda.diet.model.Address
import com.mda.diet.service.AddressService
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/address")
class AddressController(val service: AddressService) {

    @GetMapping
    fun findAll() = service.findAll()

    @PostMapping
    fun addAddress(@RequestBody address: Address)
            = service.addAddress(address)

    @PutMapping("/{id}")
    fun updateAddress(@PathVariable id: Long, @RequestBody address: Address)
        = service.updateAddress(id, address)

    @DeleteMapping("/{id}")
    fun deleteAddress(@PathVariable id: Long)
            = service.deleteAddress(id)

    @GetMapping("/{id}")
    fun getById(@PathVariable id: Long)
            = service.getById(id)
}