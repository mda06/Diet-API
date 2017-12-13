package com.mda.diet.model

data class Auth0TokenAsk(var grant_type: String = "",
                      var scope: String = "",
                      var audience: String? = "",
                      var client_id: String? = "",
                      var client_secret: String? = "",
                      var username: String = "",
                      var password: String = "")