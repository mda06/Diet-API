package com.mda.diet.dto


data class Auth0TokenAskDto(var grant_type: String = "",
                         var scope: String = "",
                         var audience: String? = "",
                         var client_id: String? = "",
                         var client_secret: String? = "",
                         var username: String = "",
                         var password: String = "")