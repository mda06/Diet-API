package com.mda.diet.controller

import org.springframework.messaging.handler.annotation.MessageMapping
import org.springframework.messaging.simp.SimpMessagingTemplate
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.text.SimpleDateFormat
import java.util.*


@Controller()
//@RequestMapping("$prefix")
class ChatController(val template: SimpMessagingTemplate) {
    @MessageMapping("/send/msg")
    fun onReceivedMessage(msg: String) {
        template.convertAndSend("/chat", SimpleDateFormat("HH:mm:ss").format(Date()) + "-$msg")
    }
}