package com.mda.diet.model

import org.springframework.data.jpa.convert.threeten.Jsr310JpaConverters
import java.time.LocalDate
import javax.persistence.*

@Entity
class MealPicture (
        @Id @GeneratedValue(strategy = GenerationType.AUTO)
        val id: Long = 0,
        val filename: String = "",
        @Convert(converter = Jsr310JpaConverters.LocalDateConverter::class)
        var date: LocalDate? = null,
        @ManyToOne
        @JoinColumn(name = "patient_id")
        val patient: Patient? = null)