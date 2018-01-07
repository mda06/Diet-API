package com.mda.diet.service

import com.mda.diet.error.CustomNotFoundException
import com.mda.diet.model.Address
import com.mda.diet.repository.AddressRepository
import org.springframework.stereotype.Service

@Service
class AddressService(val repository: AddressRepository) {
    fun findAll() = repository.findAll()

    fun addAddress(address: Address)
            = repository.save(address)

    fun updateAddress(id: Long, address: Address) : Address {
        assert(id == address.id)
        return repository.save(address)
    }

    fun deleteAddress(id: Long)
            = repository.delete(id)

    fun getById(id: Long) : Address {
        return repository.findOne(id) ?: throw CustomNotFoundException("Not found address with id $id")
    }
}