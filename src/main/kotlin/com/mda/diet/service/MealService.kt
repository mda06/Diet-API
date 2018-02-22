package com.mda.diet.service

import com.mda.diet.dto.MealDto
import com.mda.diet.error.CustomNotFoundException
import com.mda.diet.model.Meal
import com.mda.diet.model.MealProduct
import com.mda.diet.repository.DietetistRepository
import com.mda.diet.repository.MealRepository
import com.mda.diet.repository.MenuRepository
import com.mda.diet.repository.ProductRepository
import org.springframework.stereotype.Service


@Service
class MealService(val repository: MealRepository,
                  val menuRepository: MenuRepository,
                  val dietRepository: DietetistRepository,
                  val productRepository: ProductRepository) {

    fun addMeal(dto: MealDto): MealDto {
        val meal = Meal(dto.id, dto.name, dto.extraInfo, dto.score, dto.comment, null,
            dto.mealProducts.map {
                val prod = productRepository.findOne(it.productId)
                        ?: throw CustomNotFoundException("No product exists with id ${it.productId}")
                MealProduct(it.id, null, prod, it.quantity)
            }.toMutableList())

        //Check for menu or diet
        val menu = menuRepository.findOne(dto.menuId)
        val diet = dietRepository.findOne(dto.dietId)
        if(menu == null && diet == null)
            throw CustomNotFoundException("No menu exist with id ${dto.menuId} and no diet exist with id ${dto.dietId}")
        meal.menu = menu
        meal.diet = diet
        meal.mealProducts.forEach { it.meal = meal }
        return MealDto(repository.save(meal))
    }

    fun updatePatientInfo(dto: MealDto): MealDto {
        val meal = repository.findOne(dto.id) ?: throw CustomNotFoundException("No meal exists with id ${dto.id}")
        meal.comment = dto.comment
        meal.score = dto.score
        return MealDto(repository.save(meal))
    }
    
    fun deleteMeal(id: Long) = repository.delete(id)

    fun getByMenuId(id: Long) = repository.findByMenuId(id).map { MealDto(it) }

    fun getById(id: Long): MealDto {
        val meal = repository.findOne(id)?: throw CustomNotFoundException("No meal exist with id $id")
        return MealDto(meal)
    }

    fun getByDietId(id: Long) = repository.findByDietId(id).map { MealDto(it)}
}