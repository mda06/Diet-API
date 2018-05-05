package com.mda.diet.controller

import com.mda.diet.model.ChatParticipant
import com.mda.diet.repository.ChatParticipantRepository
import org.springframework.messaging.handler.annotation.MessageMapping
import org.springframework.messaging.handler.annotation.SendTo
import org.springframework.messaging.simp.annotation.SubscribeMapping
import org.springframework.stereotype.Controller
import java.text.SimpleDateFormat
import java.util.*

@Controller
class ChatController(val chatParticipantRepository: ChatParticipantRepository) {

    @SubscribeMapping("/chat.participants")
    fun retrieveParticipants(): List<ChatParticipant> {
        return chatParticipantRepository.findAll().toList()
    }

    @MessageMapping("/send/msg")
    @SendTo("/chat/msg")
    fun onReceivedMessage(msg: String): String {
        return SimpleDateFormat("HH:mm:ss").format(Date()) + "-$msg"
    }
}