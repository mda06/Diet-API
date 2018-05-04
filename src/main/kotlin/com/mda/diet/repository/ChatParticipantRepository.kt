package com.mda.diet.repository

import com.mda.diet.model.ChatParticipant
import org.springframework.data.repository.CrudRepository

interface ChatParticipantRepository: CrudRepository<ChatParticipant, Long> {
    fun findBySessionId(sessionId: String): ChatParticipant?
}