package com.mda.diet.model

data class Auth0SignupReturn(var _id: String = "",
                             var email_verified: Boolean = false,
                             var email: String = "")