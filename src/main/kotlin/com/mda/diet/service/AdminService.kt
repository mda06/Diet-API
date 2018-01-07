package com.mda.diet.service

import com.mda.diet.error.CustomNotFoundException
import com.mda.diet.model.Admin
import com.mda.diet.repository.AdminRepository
import org.springframework.stereotype.Service
import org.springframework.web.bind.annotation.*

@Service
class AdminService(val repository: AdminRepository) {
    fun findAll() = repository.findAll()

    fun addAdmin(admin: Admin)
            = repository.save(admin)

    fun updateAdmin(id: Long, admin: Admin) : Admin {
        assert(id == admin.id)
        return repository.save(admin)
    }

    fun deleteAddress(id: Long)
            = repository.delete(id)

    fun getById(id: Long)
            = repository.findOne(id) ?: throw CustomNotFoundException("Not found admin with id $id")
}