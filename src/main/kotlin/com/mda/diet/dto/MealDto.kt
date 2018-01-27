package com.mda.diet.dto

import com.mda.diet.model.Meal

data class MealDto(val id: Long = 0,
                   val name: String = "",
                   val extraInfo: String = "",
                   val score: Int = 0,
                   val comment: String = "",
                   val mealProducts:  List<MealProductDto> = listOf()) {
    constructor(meal: Meal): this(meal.id, meal.name, meal.extraInfo, meal.score, meal.comment,
            meal.mealProducts.map { MealProductDto(it.quantity, it.product.id) })
}