package com.mda.diet.model

import org.springframework.data.jpa.convert.threeten.Jsr310JpaConverters
import java.time.LocalDateTime
import javax.persistence.Convert
import javax.persistence.Entity
import javax.persistence.Id

@Entity
class LoginAccess (
        @Id
        val authId: String = "",
        @Convert(converter = Jsr310JpaConverters.LocalDateConverter::class)
        var loginTime: LocalDateTime = LocalDateTime.now(),
        @Convert(converter = Jsr310JpaConverters.LocalDateConverter::class)
        var logOutTime: LocalDateTime? = null,
        @Convert(converter = Jsr310JpaConverters.LocalDateConverter::class)
        var expirationTime: LocalDateTime = LocalDateTime.now(),
        @Convert(converter = Jsr310JpaConverters.LocalDateConverter::class)
        var lastActivityTime: LocalDateTime = LocalDateTime.now(),
        var isBlacklisted: Boolean = false)