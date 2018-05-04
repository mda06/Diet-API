package com.mda.diet.websocket

import com.mda.diet.model.ChatParticipant
import com.mda.diet.repository.ChatParticipantRepository
import org.springframework.context.event.EventListener
import org.springframework.messaging.simp.SimpMessageHeaderAccessor
import org.springframework.messaging.simp.SimpMessagingTemplate
import org.springframework.web.socket.messaging.SessionConnectEvent
import org.springframework.web.socket.messaging.SessionDisconnectEvent
import java.time.LocalDateTime
import java.util.*

class PresenceEventListener(
        private val messagingTemplate: SimpMessagingTemplate,
        private val participantRepository: ChatParticipantRepository,
        private val loginDestination: String = "/topic/chat.login",
        private val logoutDestination: String = "/topic/chat.logout") {

    @EventListener
    private fun handleSessionConnected(event: SessionConnectEvent) {
        val headers = SimpMessageHeaderAccessor.wrap(event.message)
        val username = headers?.messageHeaders?.get("nativeHeaders", Map::class.java)?.get("username")?.toString() ?: "Incognito"
        val chatParticipant = ChatParticipant(0, username, headers.sessionId, LocalDateTime.now())

        participantRepository.save(chatParticipant)
        messagingTemplate.convertAndSend(loginDestination, chatParticipant)
    }

    @EventListener
    private fun handleSessionDisconnect(event: SessionDisconnectEvent) {
        Optional.ofNullable(participantRepository.findBySessionId(event.sessionId))
                .ifPresent({ chatParticipant ->
                    messagingTemplate.convertAndSend(logoutDestination, chatParticipant)
                    participantRepository.delete(chatParticipant)
                })
    }
}
