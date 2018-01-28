package com.mda.diet.controller

import com.mda.diet.dto.MealProductDto
import com.mda.diet.service.MealProductService
import org.springframework.web.bind.annotation.*


@RestController
@RequestMapping("$prefix/meal/product")
class MealProductController(val service: MealProductService) {

    @GetMapping("/{id}")
    fun getById(@PathVariable id: Long)
            = service.getById(id)

    @GetMapping("/count/{id}")
    fun countByProductId(@PathVariable id: Long)
            = service.countByProductId(id)

    @PostMapping
    fun addMealProduct(@RequestBody dto: MealProductDto)
            = service.addMealProduct(dto)

    @DeleteMapping("/{id}")
    fun deleteMealProduct(@PathVariable id: Long)
            = service.deleteMealProduct(id)

}