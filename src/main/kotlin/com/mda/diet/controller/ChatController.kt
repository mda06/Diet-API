package com.mda.diet.controller

import org.springframework.messaging.handler.annotation.MessageMapping
import org.springframework.messaging.handler.annotation.SendTo
import org.springframework.messaging.simp.SimpMessagingTemplate
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.*
import java.text.SimpleDateFormat
import java.util.*


@Controller
class ChatController {
    @MessageMapping("/send/msg")
    @SendTo("/chat/msg")
    fun onReceivedMessage(msg: String): String {
        return SimpleDateFormat("HH:mm:ss").format(Date()) + "-$msg"
    }
}