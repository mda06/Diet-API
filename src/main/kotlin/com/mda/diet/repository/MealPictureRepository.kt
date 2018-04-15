package com.mda.diet.repository

import com.mda.diet.model.MealPicture
import org.springframework.data.repository.CrudRepository

interface MealPictureRepository : CrudRepository<MealPicture, Long> {
    fun findByPatientId(id: Long): List<MealPicture>
    fun existsByFilenameInAndPatientIdIs(filename: List<String>, id: Long): Boolean
}