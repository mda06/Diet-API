package com.mda.diet.dto

data class Auth0TokenReturnDto(var access_token: String = "",
                            var id_token: String = "",
                            var scope: String? = "",
                            var expires_in: Int = 0,
                            var token_type: String = "")