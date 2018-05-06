package com.mda.diet.websocket

import com.mda.diet.repository.ChatParticipantRepository
import com.mda.diet.repository.CustomerRepository
import org.springframework.context.annotation.*
import org.springframework.messaging.simp.SimpMessagingTemplate

@Configuration
class ChatConfig(val participantRepository: ChatParticipantRepository,
                 val customerRepository: CustomerRepository){
    @Bean
    fun presenceEventListener(messagingTemplate: SimpMessagingTemplate): PresenceEventListener =
            PresenceEventListener(messagingTemplate, customerRepository, participantRepository)
}
