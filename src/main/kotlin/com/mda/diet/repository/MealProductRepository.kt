package com.mda.diet.repository

import com.mda.diet.model.MealProduct
import org.springframework.data.repository.CrudRepository

interface MealProductRepository: CrudRepository<MealProduct, Long> {
    fun findByMealId(id: Long): List<MealProduct>
}