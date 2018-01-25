package com.mda.diet.repository

import com.mda.diet.model.Menu
import org.springframework.data.repository.CrudRepository


interface MenuRepository: CrudRepository<Menu, Long> {
    fun findByPatientId(id: Long): List<Menu>
}