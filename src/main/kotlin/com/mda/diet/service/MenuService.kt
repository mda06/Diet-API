package com.mda.diet.service

import com.mda.diet.dto.MenuDateDto
import com.mda.diet.dto.MenuDto
import com.mda.diet.error.CustomNotFoundException
import com.mda.diet.model.Meal
import com.mda.diet.model.MealProduct
import com.mda.diet.model.Menu
import com.mda.diet.repository.MenuRepository
import com.mda.diet.repository.PatientRepository
import com.mda.diet.repository.ProductRepository
import org.springframework.stereotype.Service
import java.time.LocalDate

@Service
class MenuService(val repository: MenuRepository,
                  private val patientRepository: PatientRepository,
                  private val productRepository: ProductRepository) {

    fun getById(id: Long?): MenuDto
            = MenuDto(repository.findOne(id)?: throw CustomNotFoundException("Not found menu with id $id"))

    fun getByPatientId(id: Long)
        = repository.findByPatientId(id).map { MenuDto(it) }

    fun addMenu(menuDto: MenuDto): MenuDto {
        val patient = patientRepository.findOne(menuDto.patientId)?:
                throw CustomNotFoundException("No patient exists with id ${menuDto.patientId}")
        val meals = menuDto.meals.map {
            Meal(it.id, it.name, it.extraInfo, it.score, it.comment, null,
                it.mealProducts.map {
                    try {
                        MealProduct(0, null, productRepository.findOne(it.productId), it.quantity)
                    } catch(ex: IllegalStateException) {
                        throw CustomNotFoundException("No product exists with id ${it.productId}")
                    }
                }.toMutableList())
        }

        meals.forEach {
            val meal = it
            it.mealProducts.forEach { it.meal = meal }
        }

        val menu = Menu(menuDto.id, menuDto.date, meals.toMutableList(), patient)
        meals.forEach { it.menu = menu }
        return  MenuDto(repository.save(menu))
    }

    fun deleteMenu(id: Long)
        = repository.delete(id)

    fun getByDate(month: Int, year: Int, patientId: Long)
        = repository.findByDate(month, year, patientId).map { MenuDateDto(it) }

    fun getByDate(date: LocalDate, id: Long)
        = MenuDto(repository.findByDateAndPatientIdIs(date, id) ?:
                throw CustomNotFoundException("Not found menu with date $date for patient $id"))
}