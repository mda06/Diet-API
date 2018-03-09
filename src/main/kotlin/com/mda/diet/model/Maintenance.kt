package com.mda.diet.model

import org.springframework.data.jpa.convert.threeten.Jsr310JpaConverters
import java.time.LocalDateTime
import javax.persistence.*

@Entity
class Maintenance(
        @Id @GeneratedValue(strategy = GenerationType.AUTO)
        val id: Long = 0,
        val reason: String = "",
        @Convert(converter = Jsr310JpaConverters.LocalDateTimeConverter::class)
        val beginDate: LocalDateTime? = null,
        @Convert(converter = Jsr310JpaConverters.LocalDateTimeConverter::class)
        var endDate: LocalDateTime? = null,
        var state: MaintenanceState = MaintenanceState.NONE)