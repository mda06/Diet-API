package com.mda.diet.controller

import com.mda.diet.dto.MealDto
import com.mda.diet.service.MealService
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("$prefix/meal")
class MealController(val service: MealService) {

    @GetMapping("/{id}")
    fun getById(@PathVariable id: Long)
            = service.getById(id)

    @GetMapping("/menu/{id}")
    fun getByMenuId(@PathVariable id: Long)
            = service.getByMenuId(id)

    @PostMapping
    fun addMeal(@RequestBody dto: MealDto)
            = service.addMeal(dto)

    @DeleteMapping("/{id}")
    fun deleteMeal(@PathVariable id: Long)
            = service.deleteMeal(id)

}