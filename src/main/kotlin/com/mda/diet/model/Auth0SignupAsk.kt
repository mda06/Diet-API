package com.mda.diet.model

data class Auth0SignupAsk(var customerId: Long = 0,
                  var email: String = "",
                  var password: String = "",
                  var connection: String = "",
                  var client_id: String? = "")