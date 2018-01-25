package com.mda.diet.service

import com.mda.diet.repository.MealRepository
import org.springframework.stereotype.Service


@Service
class MealService(val repository: MealRepository) {

    fun deleteMeal(id: Long)
            = repository.delete(id)
}