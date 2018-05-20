package com.mda.diet.websocket

import com.mda.diet.dto.ChatParticipantDto
import com.mda.diet.error.CustomerNotFoundException
import com.mda.diet.model.ChatParticipant
import com.mda.diet.repository.ChatParticipantRepository
import com.mda.diet.repository.CustomerRepository
import org.springframework.context.event.EventListener
import org.springframework.messaging.simp.SimpMessageHeaderAccessor
import org.springframework.messaging.simp.SimpMessagingTemplate
import org.springframework.web.socket.messaging.SessionConnectEvent
import org.springframework.web.socket.messaging.SessionDisconnectEvent
import java.util.*

class PresenceEventListener(
        private val messagingTemplate: SimpMessagingTemplate,
        private val customerRepository: CustomerRepository,
        private val participantRepository: ChatParticipantRepository,
        private val loginDestination: String = "/topic/chat.login",
        private val logoutDestination: String = "/topic/chat.logout") {

    @EventListener
    private fun handleSessionConnected(event: SessionConnectEvent) {
        val headers = SimpMessageHeaderAccessor.wrap(event.message)
        var authId = headers?.messageHeaders?.get("nativeHeaders", Map::class.java)?.get("authId")?.toString()
                ?: throw CustomerNotFoundException("No authId was found in the nativeHeaders !")
        authId = authId.replace("[", "").replace("]", "")

        //Check if the participant already exist
        val chatParticipant = participantRepository.findByAuthId(authId)
                    ?: ChatParticipant(0, "", authId)

        //Update the username and sessionId
        val customer = customerRepository.getByAuthId(authId)
        chatParticipant.username = "${customer.firstName} ${customer.lastName}"
        chatParticipant.sessionId = headers.sessionId

        participantRepository.save(chatParticipant)
        messagingTemplate.convertAndSend(loginDestination, ChatParticipantDto(chatParticipant))
    }

    @EventListener
    private fun handleSessionDisconnect(event: SessionDisconnectEvent) {
        Optional.ofNullable(participantRepository.findBySessionId(event.sessionId))
                .ifPresent({ chatParticipant ->
                    chatParticipant.sessionId = null
                    participantRepository.save(chatParticipant)
                    messagingTemplate.convertAndSend(logoutDestination, ChatParticipantDto(chatParticipant))
                })
    }
}
