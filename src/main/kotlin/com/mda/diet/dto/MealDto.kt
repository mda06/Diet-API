package com.mda.diet.dto

import com.mda.diet.model.Meal

data class MealDto(val id: Long = 0,
                   val dietId: Long = 0,
                   val menuId: Long = 0,
                   val name: String = "",
                   val extraInfo: String = "",
                   val score: Int = 0,
                   val comment: String = "",
                   val mealProducts:  List<MealProductDto> = listOf()) {
    constructor(meal: Meal): this(meal.id, meal.diet?.id ?: 0, meal.menu?.id ?: 0, meal.name,
            meal.extraInfo, meal.score, meal.comment, meal.mealProducts.map { MealProductDto(it) })
}