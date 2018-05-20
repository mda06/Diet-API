package com.mda.diet.dto

import com.mda.diet.model.MealPicture
import java.time.LocalDate

data class MealPictureDto(
        val id: Long = 0,
        val date: LocalDate? = null,
        val filename: String = "") {
    constructor(picture: MealPicture) : this(picture.id, picture.date, picture.filename)
}