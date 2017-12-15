package com.mda.diet.repository

import com.mda.diet.model.Customer
import org.springframework.data.repository.CrudRepository

interface CustomerRepository : CrudRepository<Customer, Long> {
    fun getById(id: Long): Customer
    fun getByAuthId(id: String): Customer
}