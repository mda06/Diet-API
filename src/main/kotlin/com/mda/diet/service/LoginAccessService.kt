package com.mda.diet.service

import com.auth0.jwt.JWT
import com.auth0.jwt.exceptions.JWTDecodeException
import com.mda.diet.dto.LoginBlacklistDto
import com.mda.diet.dto.MaintenanceDto
import com.mda.diet.error.CustomNotFoundException
import com.mda.diet.error.LoginException
import com.mda.diet.model.LoginAccess
import com.mda.diet.model.Maintenance
import com.mda.diet.model.MaintenanceState
import com.mda.diet.repository.LoginAccessRepository
import com.mda.diet.repository.MaintenanceRepository
import org.springframework.stereotype.Service
import java.time.Clock
import java.time.LocalDateTime
import java.util.*

@Service
class LoginAccessService(val repository: LoginAccessRepository,
                         val maintenanceRepository: MaintenanceRepository) {

    var maintenance: Maintenance? = null

    fun isInMaintenance()
            = maintenance != null

    fun putInMaintenance(maintenance: MaintenanceDto)
        = putInMaintenance(maintenance.reason)

    fun putInMaintenance(reason: String?): Maintenance {
        if(maintenance != null) throw LoginException("Cannot put in maintenance, it's already in maintenance !")
        maintenance = Maintenance(0, reason ?: "", LocalDateTime.now(Clock.systemUTC()), null, MaintenanceState.BEGIN)
        return maintenanceRepository.save(maintenance)!!
    }

    fun removeMaintenance(): Maintenance {
        if(maintenance == null) throw LoginException("It's not in maintenance !")
        maintenance?.endDate = LocalDateTime.now(Clock.systemUTC())
        maintenance?.state = MaintenanceState.END
        val ret = maintenanceRepository.save(maintenance)
        maintenance = null
        return ret!!
    }

    fun getAll()
        = repository.findAll()

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

    fun onLogout(id: String): LoginAccess {
        val login = repository.findOne(id) ?: throw CustomNotFoundException("No login access found with id: $id")
        login.lastActivityTime = LocalDateTime.now(Clock.systemUTC())
        login.logOutTime = LocalDateTime.now(Clock.systemUTC())
        return repository.save(login)
    }

    fun addActivity(id: String): LoginAccess {
        val login = repository.findOne(id) ?: throw CustomNotFoundException("No login access found with id: $id")
        login.lastActivityTime = LocalDateTime.now(Clock.systemUTC())
        return repository.save(login)
    }

    fun getMaintenanceStatus(): Maintenance {
        if(maintenance == null)
            return maintenanceRepository.findFirstByOrderByIdDesc() ?: Maintenance()
        return maintenance!!
    }

    fun blacklistLogin(blacklistDto: LoginBlacklistDto): LoginAccess {
        val login = repository.findOne(blacklistDto.id) ?: throw CustomNotFoundException("No login access found with id: ${blacklistDto.id}")
        login.isBlacklisted = true
        return repository.save(login)
    }

    fun unBlacklistLogin(blockDto: LoginBlacklistDto): LoginAccess {
        val login = repository.findOne(blockDto.id) ?: throw CustomNotFoundException("No login access found with id: ${blockDto.id}")
        login.isBlacklisted = false
        return repository.save(login)
    }

    fun isBlacklisted(id: String): Boolean {
        val login = repository.findOne(id) ?: throw CustomNotFoundException("No login access found with id: $id")
        return login.isBlacklisted
    }

}