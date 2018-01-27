package com.mda.diet.service

import com.mda.diet.dto.MealDto
import com.mda.diet.error.CustomNotFoundException
import com.mda.diet.model.Meal
import com.mda.diet.model.MealProduct
import com.mda.diet.repository.MealProductRepository
import com.mda.diet.repository.MealRepository
import com.mda.diet.repository.MenuRepository
import com.mda.diet.repository.ProductRepository
import org.springframework.stereotype.Service


@Service
class MealService(val repository: MealRepository,
                  val menuRepository: MenuRepository,
                  val mealProductRepository: MealProductRepository,
                  val productRepository: ProductRepository) {

    fun addMeal(dto: MealDto): MealDto {
        val meal = Meal(dto.id, dto.name, dto.extraInfo, dto.score, dto.comment, null)
        //Don't set the mealproducts if this is an update
        //if(dto.id == 0L) {
            meal.mealProducts = dto.mealProducts.map {
                val prod = productRepository.findOne(it.productId)
                        ?: throw CustomNotFoundException("No product exists with id ${it.productId}")
                MealProduct(it.id, null, prod, it.quantity)
            }.toMutableList()
        /*} else {
            //Take the ohters meal products if it's an update
            meal.mealProducts = mealProductRepository.findByMealId(dto.id)
        }*/

        val menu = menuRepository.findOne(dto.menuId)?: throw CustomNotFoundException("No menu exist with id ${dto.menuId}")
        meal.menu = menu
        meal.mealProducts.forEach { it.meal = meal }
        return MealDto(repository.save(meal), dto.menuId)
    }
    
    fun deleteMeal(id: Long)
            = repository.delete(id)
}