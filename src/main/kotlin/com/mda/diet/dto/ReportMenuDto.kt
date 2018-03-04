package com.mda.diet.dto

import org.springframework.data.jpa.convert.threeten.Jsr310JpaConverters
import java.time.LocalDate
import javax.persistence.Convert

data class ReportMenuDto(@Convert(converter = Jsr310JpaConverters.LocalDateConverter::class)
                         val date: LocalDate? = null,
                         val macros: List<NutrimentDto> = listOf(),
                         val micros: List<NutrimentDto> = listOf())