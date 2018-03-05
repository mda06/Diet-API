package com.mda.diet.service

import com.auth0.jwt.JWT
import com.auth0.jwt.exceptions.JWTDecodeException
import com.mda.diet.model.LoginAccess
import com.mda.diet.repository.LoginAccessRepository
import org.springframework.stereotype.Service
import java.util.*
import javax.security.auth.login.LoginException

@Service
class LoginAccessService(val repository: LoginAccessRepository) {
    fun onLogin(token: String): LoginAccess {
        val jwt =  try {
                JWT.decode(token)
            } catch (ex: JWTDecodeException) {
                throw LoginException("Not a valid token given: $token")
            }
        val loginAccess = LoginAccess(jwt.subject, toLocalDateTime(jwt.issuedAt), null,
                toLocalDateTime(jwt.expiresAt), toLocalDateTime(jwt.issuedAt), false)
        return repository.save(loginAccess)
    }

    fun toLocalDateTime(timestamp: Date)
        = java.sql.Timestamp(timestamp.time).toLocalDateTime()!!

}