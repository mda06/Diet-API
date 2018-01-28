package com.mda.diet.dto

import com.mda.diet.model.MealProduct

data class MealProductDto(val id: Long = 0,
                          val quantity: Int = 0,
                          val productId: Long = 0,
                          val mealId: Long = 0) {
    constructor(mp: MealProduct): this(mp.id, mp.quantity, mp.product?.id ?: 0, mp.meal?.id ?: 0)
}