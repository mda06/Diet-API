package com.mda.diet.model

import javax.persistence.*

@Entity
class ChatParticipant (
        @Id @GeneratedValue(strategy = GenerationType.AUTO)
        var id: Long = 0,
        var username: String = "",
        var authId: String = "",
        var sessionId: String? = null)