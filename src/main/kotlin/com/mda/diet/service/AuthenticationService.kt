package com.mda.diet.service

import com.mda.diet.dto.*
import com.mda.diet.error.CustomNotFoundException
import com.mda.diet.error.CustomerNotFoundException
import com.mda.diet.error.LoginException
import com.mda.diet.error.SignupException
import com.mda.diet.model.Admin
import com.mda.diet.model.Customer
import com.mda.diet.model.Dietetist
import com.mda.diet.model.Patient
import com.mda.diet.repository.CustomerRepository
import org.springframework.beans.factory.annotation.Value
import org.springframework.http.HttpHeaders
import org.springframework.http.HttpMethod
import org.springframework.http.MediaType
import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.stereotype.Service
import org.springframework.web.client.HttpClientErrorException
import org.springframework.web.client.RestTemplate
import org.springframework.http.HttpEntity



@Service
class AuthenticationService(val repository: CustomerRepository,
                            val customerRepository: CustomerRepository) {
    @Value("\${auth0.client.id}")
    private val clientId: String? = null

    @Value("\${auth0.client.secret}")
    private val clientSecret: String? = null

    @Value("\${auth0.audience}")
    private val audience: String? = null

    @Value("\${auth0.issuer}")
    private val issuer: String? = null

    //Get the current id that has been authenticated
    //SecurityContextHolder.getContext().authentication.principal.toString()

    fun signUp(signup: Auth0SignupAskDto) : Auth0SignupReturnDto {
        signup.client_id = clientId
        signup.connection = "Username-Password-Authentication"
        val customer = repository.getById(signup.customerId)
        val rest = RestTemplate()

        //1 Check if username is already taken
        val exist = existUsername(signup.email)
        if(exist) {
            throw SignupException("Username ${signup.email} already exist")
        }

        //2 Create the new account
        try {
            val signupReturn = rest.postForObject("${issuer}dbconnections/signup", signup, Auth0SignupReturnDto::class.java)
            customer.authId = "auth0|" + signupReturn._id
            repository.save(customer)
            return signupReturn
        } catch (ex: HttpClientErrorException) {
            throw IllegalArgumentException(ex.message)
        }
    }

    fun getManagementToken(): String {
        val token: String
        val rest = RestTemplate()

        try {
            val askToken = Auth0TokenAskDto()
            askToken.audience = "https://mdatest.eu.auth0.com/api/v2/"
            askToken.client_id = clientId
            askToken.client_secret = clientSecret
            askToken.grant_type = "client_credentials"
            val ret = rest.postForObject("${issuer}oauth/token", askToken, Auth0TokenReturnDto::class.java)
            token = ret.access_token
        } catch (ex: Throwable) {
            throw IllegalArgumentException(ex.message)
        }
        return token
    }

    fun existUsername(email: String) : Boolean {
        val token: String = getManagementToken()
        val rest = RestTemplate()

        try {
            val headers = HttpHeaders()
            headers.contentType = MediaType.APPLICATION_JSON
            headers.set("Authorization", "Bearer "+ token)
            val entity = HttpEntity<String>(headers)
            val existEmail = rest.exchange("$issuer/api/v2/users-by-email?email=$email",
                    HttpMethod.GET, entity, Any::class.java)
            return (existEmail.body as ArrayList<*>).size != 0
        } catch(ex: HttpClientErrorException) {
            throw IllegalArgumentException(ex.message)
        }
    }

    fun getToken(token: Auth0TokenAskDto) : Auth0TokenReturnDto {
        token.audience = audience
        token.client_id = clientId
        token.client_secret = clientSecret
        token.grant_type = "password"
        token.scope = "openid "
        when {
            token.username.endsWith("@admin.com") -> token.scope += "scope:admin"
            token.username.endsWith("@patient.com") -> token.scope += "scope:patient"
            token.username.endsWith("@diet.com") -> token.scope += "scope:diet"
        }

        val rest = RestTemplate()
        try {
            return rest.postForObject("${issuer}oauth/token", token, Auth0TokenReturnDto::class.java)
        } catch (ex: Throwable) {
            throw LoginException("Cannot connect")
        }
    }

    fun getUser() : Any {
        val cust = repository.getByAuthId(SecurityContextHolder.getContext().authentication.principal.toString())
        return if(cust is Dietetist) DietetistDto(cust) else cust
    }

    fun getRole() =
        when(getUser()) {
            is DietetistDto -> RoleDto.DIET
            is Admin -> RoleDto.ADMIN
            is Patient -> RoleDto.PATIENT
            else -> throw CustomerNotFoundException("No customer found with this token")
        }

    fun getId() = repository.getByAuthId(SecurityContextHolder.getContext().authentication.principal.toString()).id

    fun deleteUser(id: Long) {
        val token: String = getManagementToken()
        val rest = RestTemplate()
        val customer = customerRepository.findOne(id) ?: throw CustomNotFoundException("No customer found with id $id")

        try {
            val headers = HttpHeaders()
            headers.contentType = MediaType.APPLICATION_JSON
            headers.set("Authorization", "Bearer "+ token)
            val entity = HttpEntity<String>(headers)
            rest.exchange("${issuer}api/v2/users/${customer.authId}", HttpMethod.DELETE, entity, Any::class.java)
            customerRepository.delete(id)
        } catch(ex: HttpClientErrorException) {
            throw IllegalArgumentException(ex.message)
        }
    }


}