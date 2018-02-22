package com.mda.diet.dto

import com.mda.diet.model.Dietetist


data class DietetistNameDto(
        val id: Long = 0,
        val firstName: String = "",
        val lastName: String = "") {
    constructor(diet: Dietetist) : this(diet.id, diet.firstName, diet.lastName)
}