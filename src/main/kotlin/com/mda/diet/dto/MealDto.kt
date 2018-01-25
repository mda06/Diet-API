package com.mda.diet.dto

data class MealDto(val id: Long = 0,
                   val name: String = "",
                   val extraInfo: String = "",
                   val score: Int = 0,
                   val comment: String = "",
                   val productIds: List<Long> = listOf())