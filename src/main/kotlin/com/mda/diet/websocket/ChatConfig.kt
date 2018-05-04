package com.mda.diet.websocket

import com.mda.diet.repository.ChatParticipantRepository
import org.springframework.context.annotation.*
import org.springframework.messaging.simp.SimpMessagingTemplate

@Configuration
class ChatConfig(val participantRepository: ChatParticipantRepository){
    @Bean
    fun presenceEventListener(messagingTemplate: SimpMessagingTemplate): PresenceEventListener =
            PresenceEventListener(messagingTemplate, participantRepository)
}
