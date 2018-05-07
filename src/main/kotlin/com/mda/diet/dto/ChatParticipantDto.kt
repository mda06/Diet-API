package com.mda.diet.dto

import com.mda.diet.model.ChatParticipant

data class ChatParticipantDto(var id: Long = 0,
                              var username: String = "",
                              var authId: String = "",
                              var sessionId: String? = null) {
    constructor(chatParticipant: ChatParticipant) :
            this(chatParticipant.id, chatParticipant.username, chatParticipant.authId, chatParticipant.sessionId)
}