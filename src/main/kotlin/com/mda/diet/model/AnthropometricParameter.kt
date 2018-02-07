package com.mda.diet.model

import com.fasterxml.jackson.annotation.*
import org.springframework.data.jpa.convert.threeten.Jsr310JpaConverters
import java.time.LocalDate
import javax.persistence.*


@Entity
/*@JsonIdentityInfo(
        generator = ObjectIdGenerators.PropertyGenerator::class,
        property = "id")*/
class AnthropometricParameter(
        @Id @GeneratedValue(strategy = GenerationType.AUTO)
        var id: Long = 0,
        var length: Int = 0,
        var weight: Double = 0.0,
        var bodyFat: Double = 0.0,
        var waistCircumference: Double = 0.0,
        @Convert(converter = Jsr310JpaConverters.LocalDateConverter::class)
        var date: LocalDate? = null,
        var patientId: Long? = null)