package com.mda.diet.dto

data class ChatMessageDto(var from: String = "",
                          var to: String = "",
                          val message: String = "")