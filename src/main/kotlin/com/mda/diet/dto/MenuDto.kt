package com.mda.diet.dto

import com.mda.diet.model.Menu
import org.springframework.data.jpa.convert.threeten.Jsr310JpaConverters
import java.time.LocalDate
import javax.persistence.Convert

data class MenuDto(val id: Long = 0,
                   val patientId: Long = 0,
                   @Convert(converter = Jsr310JpaConverters.LocalDateConverter::class)
                   val date: LocalDate? = null,
                   val meals: List<MealDto> = listOf()) {

    constructor(menu: Menu): this(menu.id, menu.patient!!.id, menu.date,
            menu.meals.map { MealDto(it) })
}