package com.mda.diet.dto

data class Auth0SignupAskDto(var customerId: Long = 0,
                          var email: String = "",
                          var password: String = "",
                          var connection: String = "",
                          var client_id: String? = "")