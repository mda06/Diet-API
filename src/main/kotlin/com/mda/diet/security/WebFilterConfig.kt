package com.mda.diet.security

import com.auth0.jwt.JWT
import com.mda.diet.service.LoginAccessService
import org.slf4j.LoggerFactory
import org.springframework.core.Ordered
import org.springframework.core.annotation.Order
import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.stereotype.Component

import javax.servlet.*
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse
import java.io.IOException

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

        if(token != null) {
            token = token.replace("Bearer ", "")
            val jwt = JWT.decode(token)
            loginAccessService.addActivity(jwt.subject)
        }
        if (CONDITION) {
            // Goes to default servlet
            chain.doFilter(request, response)
        } else {
            (response as HttpServletResponse).status = HttpServletResponse.SC_BAD_REQUEST
        }
    }

    override fun destroy() {
        logger.debug("Destroying WebFilter >> ")
    }

    companion object {
        private val logger = LoggerFactory.getLogger(WebFilterConfig::class.java)
        private val CONDITION = true
    }
}