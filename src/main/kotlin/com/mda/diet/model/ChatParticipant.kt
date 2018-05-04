package com.mda.diet.model

import org.springframework.data.jpa.convert.threeten.Jsr310JpaConverters
import java.time.LocalDateTime
import javax.persistence.*

@Entity
class ChatParticipant (
        @Id @GeneratedValue(strategy = GenerationType.AUTO)
        var id: Long = 0,
        var userName: String = "",
        var sessionId: String = "",
        @Convert(converter = Jsr310JpaConverters.LocalDateTimeConverter::class)
        var connectionDateTime: LocalDateTime? = null)