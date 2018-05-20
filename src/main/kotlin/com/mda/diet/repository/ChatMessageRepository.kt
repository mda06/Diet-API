package com.mda.diet.repository

import com.mda.diet.model.ChatMessage
import org.springframework.data.repository.CrudRepository

interface ChatMessageRepository: CrudRepository<ChatMessage, Long>