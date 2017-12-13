package com.mda.diet.model

import com.fasterxml.jackson.annotation.JsonBackReference
import org.springframework.data.jpa.convert.threeten.Jsr310JpaConverters
import java.time.LocalDate
import javax.persistence.*


@Entity
class AnthropometricParameter(
        @Id @GeneratedValue(strategy = GenerationType.AUTO)
        var id: Long = 0,
        var length: Int = 0,
        var weight: Double = 0.0,
        var bodyFat: Double = 0.0,
        var waistCircumference: Double = 0.0,
        @Convert(converter = Jsr310JpaConverters.LocalDateConverter::class)
        var date: LocalDate? = null,
        @ManyToOne
        @JoinColumn(name = "patient_id")
        @JsonBackReference
        var patient: Patient? = null)