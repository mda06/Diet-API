package com.mda.diet.security

import com.auth0.jwt.JWT
import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import com.mda.diet.error.LoginException
import com.mda.diet.service.LoginAccessService
import org.slf4j.LoggerFactory
import org.springframework.core.Ordered
import org.springframework.core.annotation.Order
import org.springframework.stereotype.Component

import javax.servlet.*
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse
import java.io.IOException
import com.mda.diet.error.ApiError
import org.springframework.http.HttpStatus



@Component
@Order(Ordered.HIGHEST_PRECEDENCE)
class WebFilterConfig(val loginAccessService: LoginAccessService) : Filter {

    @Throws(ServletException::class)
    override fun init(filterConfig: FilterConfig) {
        logger.debug("Initiating WebFilter >> ")
        println("Starting filter...")
    }

    @Throws(IOException::class, ServletException::class)
    override fun doFilter(request: ServletRequest, response: ServletResponse,
                          chain: FilterChain) {
        val req = request as HttpServletRequest
        var token = req.getHeader("authorization")
        var isAdmin = false

        if(token != null) {
            token = token.replace("Bearer ", "")
            val jwt = JWT.decode(token)
            val scope = jwt.getClaim("scope")
            if(scope != null && scope.asString().contains("scope:admin"))
                isAdmin = true
            loginAccessService.addActivity(jwt.subject)
        }

        if (!loginAccessService.isInMaintenance() || isAdmin) {
            chain.doFilter(request, response)
        } else {
            setErrorResponse(HttpStatus.BAD_REQUEST, response as HttpServletResponse,
                    LoginException("API is in maintenance for: ${loginAccessService.maintenance?.reason}"))
        }
    }

    fun setErrorResponse(status: HttpStatus, response: HttpServletResponse, ex: Throwable) {
        response.status = status.value()
        response.contentType = "application/json"
        // A class used for errors
        val apiError = ApiError(status, ex.message)
        try {
            val json = jacksonObjectMapper().writeValueAsString(apiError)
            println(json)
            response.writer.write(json)
        } catch (e: IOException) {
            e.printStackTrace()
        }

    }

    override fun destroy() {
        logger.debug("Destroying WebFilter >> ")
    }

    companion object {
        private val logger = LoggerFactory.getLogger(WebFilterConfig::class.java)
    }
}