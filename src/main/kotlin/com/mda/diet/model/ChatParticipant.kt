package com.mda.diet.model

import javax.persistence.*

@Entity
class ChatParticipant (
        @Id @GeneratedValue(strategy = GenerationType.AUTO)
        var id: Long = 0,
        var username: String = "",
        var authId: String = "",
        var sessionId: String? = null,
        @OneToMany(mappedBy = "from", cascade = [CascadeType.ALL], orphanRemoval = true)
        var sendMessages: MutableList<ChatMessage> = mutableListOf(),
        @OneToMany(mappedBy = "to", cascade = [CascadeType.ALL], orphanRemoval = true)
        var receivedMessages: MutableList<ChatMessage> = mutableListOf())