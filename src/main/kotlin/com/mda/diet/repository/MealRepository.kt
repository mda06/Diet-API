package com.mda.diet.repository

import com.mda.diet.model.Meal
import org.springframework.data.repository.CrudRepository

interface MealRepository: CrudRepository<Meal, Long> {
    fun findByMenuId(id: Long): List<Meal>
}