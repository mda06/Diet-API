package com.mda.diet.service

import com.mda.diet.dto.MealDto
import com.mda.diet.dto.MenuDto
import com.mda.diet.error.CustomNotFoundException
import com.mda.diet.model.Meal
import com.mda.diet.model.Menu
import com.mda.diet.model.Product
import com.mda.diet.repository.MenuRepository
import com.mda.diet.repository.PatientRepository
import com.mda.diet.repository.ProductRepository
import org.springframework.stereotype.Service

@Service
class MenuService(val repository: MenuRepository,
                  private val patientRepository: PatientRepository,
                  private val productRepository: ProductRepository) {

    fun addMenu(menuDto: MenuDto): Any {
        val patient = patientRepository.findOne(menuDto.patientId)?:
                throw CustomNotFoundException("No patient exists with id ${menuDto.patientId}")
        val meals = menuDto.meals.map { Meal(it.id, it.name, it.extraInfo, it.score, it.comment, null,
                productRepository.findAll(it.productIds) as MutableList<Product>) }
        val menu = Menu(menuDto.id, menuDto.date, meals as MutableList<Meal>, patient)
        meals.forEach { it.menu = menu }
        //Return the dto instead of this menu
        val saved = repository.save(menu)
        return MenuDto(saved.id, saved.patient!!.id, saved.date, saved.meals.map {
            MealDto(it.id, it.name, it.extraInfo, it.score, it.comment,
                    it.products.map { it.id })
        })
    }

    fun deleteMenu(id: Long)
        = repository.delete(id)
}