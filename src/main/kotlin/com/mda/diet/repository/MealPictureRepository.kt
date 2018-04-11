package com.mda.diet.repository

import com.mda.diet.model.MealPicture
import org.springframework.data.repository.CrudRepository

interface MealPictureRepository : CrudRepository<MealPicture, Long>