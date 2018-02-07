package com.mda.diet.service

import com.mda.diet.dto.MealProductDto
import com.mda.diet.error.CustomNotFoundException
import com.mda.diet.model.MealProduct
import com.mda.diet.repository.MealProductRepository
import com.mda.diet.repository.MealRepository
import com.mda.diet.repository.ProductRepository
import org.springframework.stereotype.Service


@Service
class MealProductService(val repository: MealProductRepository,
                         val productRepository: ProductRepository,
                         val mealRepository: MealRepository) {

    fun addMealProduct(dto: MealProductDto): MealProductDto {
        val product = productRepository.findOne(dto.productId)?:
                throw CustomNotFoundException("No product exists with id ${dto.productId}")
        val meal = mealRepository.findOne(dto.mealId)?:
                throw CustomNotFoundException("No meal exists with id ${dto.mealId}")
        val mp = MealProduct(dto.id, meal, product, dto.quantity)
        return MealProductDto(repository.save(mp))
    }

    fun deleteMealProduct(id: Long) = repository.delete(id)

    fun countByProductId(id: Long) = repository.countByProductId(id)

    fun getById(id: Long): MealProductDto {
        val mealProduct = repository.findOne(id)?: throw CustomNotFoundException("No mealproduct exist with id $id")
        return MealProductDto(mealProduct)
    }
}