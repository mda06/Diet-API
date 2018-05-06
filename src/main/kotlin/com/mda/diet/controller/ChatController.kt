package com.mda.diet.controller

import com.mda.diet.dto.ChatMessageDto
import com.mda.diet.dto.DietetistDto
import com.mda.diet.dto.RoleDto
import com.mda.diet.error.CustomerNotFoundException
import com.mda.diet.model.Admin
import com.mda.diet.model.ChatParticipant
import com.mda.diet.model.Dietetist
import com.mda.diet.model.Patient
import com.mda.diet.repository.ChatParticipantRepository
import com.mda.diet.repository.CustomerRepository
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
                     val customerRepository: CustomerRepository,
                     val simpMessagingTemplate: SimpMessagingTemplate) {

    @SubscribeMapping("/chat.participants")
    fun retrieveParticipants(headerAccessor: SimpMessageHeaderAccessor): List<ChatParticipant> {
        val participant = chatParticipantRepository.findBySessionId(headerAccessor.sessionId)
        val customer = customerRepository.getByAuthId(participant?.authId ?: "")

        val iterable = chatParticipantRepository.findAll()
                .filter { it.authId != participant?.authId }

        //TODO: Check the participants here but also in connect/disconnect...

//        when(customer) {
//            is Dietetist -> {
//                //Diet can only see his patients
//                iterable = iterable.filter { customer.patients.map { it.authId }.contains(it.authId) }
//            }
//
//            is Patient -> {
//                //Patient can only see his diet
//                iterable = iterable.filter { it.authId == customerRepository.findOne(customer.dietetistId).authId}
//            }
//            //Admin can see all the participants
//        }

        return iterable.toList()
    }

    @MessageMapping("/send/msg")
    @SendTo("/chat/msg")
    fun onReceivedMessage(msg: String): String {
        return SimpleDateFormat("HH:mm:ss").format(Date()) + "-$msg"
    }

    @MessageMapping("/chat.private.{authId}")
    fun onPrivateMessageReceived(@Payload msg: ChatMessageDto,
                                 @DestinationVariable("authId") authId: String,
                                 headerAccessor: SimpMessageHeaderAccessor) {
        val fromParticipant = chatParticipantRepository.findBySessionId(headerAccessor.sessionId)
                ?: throw CustomerNotFoundException("No chat participant was found with this session id ${headerAccessor.sessionId}")
        val toParticipant = chatParticipantRepository.findByAuthId(authId)
                ?: throw CustomerNotFoundException("No chat participant was found with this auth id $authId")

        msg.from = fromParticipant.username
        msg.to = toParticipant.username
        simpMessagingTemplate.convertAndSend("/chat/private/${toParticipant.authId}", msg)
        simpMessagingTemplate.convertAndSend("/chat/private/${fromParticipant.authId}", msg)
    }
}