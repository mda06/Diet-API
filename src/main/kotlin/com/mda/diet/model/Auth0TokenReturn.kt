package com.mda.diet.model


data class Auth0TokenReturn(var access_token: String = "",
                            var id_token: String = "",
                            var scope: String? = "",
                            var expires_in: Int = 0,
                            var token_type: String = "")