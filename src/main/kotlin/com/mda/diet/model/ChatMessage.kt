package com.mda.diet.model

import javax.persistence.*

@Entity
class ChatMessage (
        @Id @GeneratedValue(strategy = GenerationType.AUTO)
        val id: Long = 0,
        val message: String = "",
        @ManyToOne
        @JoinColumn(name = "to_participant")
        val to: ChatParticipant = ChatParticipant(),
        @ManyToOne
        @JoinColumn(name = "from_participant")
        val from: ChatParticipant = ChatParticipant())