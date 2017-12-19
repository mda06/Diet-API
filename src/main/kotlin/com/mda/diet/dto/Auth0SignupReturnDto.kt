package com.mda.diet.dto

data class Auth0SignupReturnDto(var _id: String = "",
                             var email_verified: Boolean = false,
                             var email: String = "")