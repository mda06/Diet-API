package com.mda.diet.controller

import com.mda.diet.service.MealService
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("$prefix/meal")
class MealController(val service: MealService) {

    @DeleteMapping("/{id}")
    fun deleteMenu(@PathVariable id: Long)
            = service.deleteMeal(id)

}