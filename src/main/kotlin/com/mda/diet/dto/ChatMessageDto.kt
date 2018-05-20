package com.mda.diet.dto

import com.mda.diet.model.ChatMessage

data class ChatMessageDto(var from: String = "",
                          var to: String = "",
                          val message: String = "") {
    constructor(msg: ChatMessage) : this(msg.from.username, msg.to.username, msg.message)
}