package com.mda.diet.controller

import com.mda.diet.dto.ChatMessageDto
import com.mda.diet.model.ChatParticipant
import com.mda.diet.repository.ChatParticipantRepository
import org.springframework.messaging.handler.annotation.DestinationVariable
import org.springframework.messaging.handler.annotation.MessageMapping
import org.springframework.messaging.handler.annotation.Payload
import org.springframework.messaging.handler.annotation.SendTo
import org.springframework.messaging.simp.SimpMessageHeaderAccessor
import org.springframework.messaging.simp.SimpMessagingTemplate
import org.springframework.messaging.simp.annotation.SubscribeMapping
import org.springframework.stereotype.Controller
import java.text.SimpleDateFormat
import java.util.*

@Controller
class ChatController(val chatParticipantRepository: ChatParticipantRepository,
                     val simpMessagingTemplate: SimpMessagingTemplate) {

    @SubscribeMapping("/chat.participants")
    fun retrieveParticipants(): List<ChatParticipant> {
        return chatParticipantRepository.findAll().toList()
    }

    @MessageMapping("/send/msg")
    @SendTo("/chat/msg")
    fun onReceivedMessage(msg: String): String {
        return SimpleDateFormat("HH:mm:ss").format(Date()) + "-$msg"
    }

    @MessageMapping("/chat.private.{username}")
    fun onPrivateMessageReceived(@Payload msg: ChatMessageDto,
                                 @DestinationVariable("username") username: String,
                                 headerAccessor: SimpMessageHeaderAccessor) {
        val participant = chatParticipantRepository.findBySessionId(headerAccessor.sessionId)
        msg.from = participant?.userName ?: "Incognito"
        msg.to = username
        simpMessagingTemplate.convertAndSend("/chat/private/${msg.to}", msg)
        simpMessagingTemplate.convertAndSend("/chat/private/${msg.from}", msg)
    }
}