package com.mda.diet.security

import org.springframework.context.annotation.Configuration
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter
import com.auth0.spring.security.api.JwtWebSecurityConfigurer
import org.springframework.beans.factory.annotation.Value
import org.springframework.http.HttpMethod


@Configuration
@EnableWebSecurity
class WebSecurityConfig : WebSecurityConfigurerAdapter() {

    @Value("\${auth0.audience}")
    private val audience: String? = null

    @Value("\${auth0.issuer}")
    private val issuer: String? = null

    @Throws(Exception::class)
    override fun configure(http: HttpSecurity) {
        JwtWebSecurityConfigurer
                .forRS256(audience, issuer!!)
                .configure(http)
                .authorizeRequests()
                .antMatchers( "/*").permitAll()
                .antMatchers( "/assets/**").permitAll()
                .antMatchers(HttpMethod.POST, "/api/auth/login").permitAll()
                .antMatchers("/api/**").authenticated()
                .antMatchers(HttpMethod.POST, "/api/product/batch")
                    .hasAuthority("scope:admin")
                .antMatchers(HttpMethod.POST, "/api/product/fav/add")
                    .hasAnyAuthority("scope:diet", "scope:admin")
                .antMatchers(HttpMethod.POST, "/api/product/fav/remove")
                    .hasAnyAuthority("scope:diet", "scope:admin")
                .antMatchers(HttpMethod.POST, "/api/menu/")
                    .hasAnyAuthority("scope:diet", "scope:admin")
                .antMatchers(HttpMethod.DELETE, "/api/menu/")
                    .hasAnyAuthority("scope:diet", "scope:admin")
                .antMatchers(HttpMethod.POST, "/api/meal/")
                    .hasAnyAuthority("scope:diet", "scope:admin")
                .antMatchers(HttpMethod.DELETE, "/api/meal/")
                    .hasAnyAuthority("scope:diet", "scope:admin")
                .antMatchers(HttpMethod.DELETE, "/api/product/*")
                    .hasAnyAuthority("scope:admin")
                .antMatchers("/api/login-access/*")
                    .hasAnyAuthority("scope:admin")
                .antMatchers(HttpMethod.POST, "/api/maintenance/enable").hasAnyAuthority("scope:admin")
                .antMatchers(HttpMethod.DELETE, "/api/maintenance/disable").hasAnyAuthority("scope:admin")
                //.antMatchers(HttpMethod.POST, "/api/meal/patient")
                    //.permitAll()
                //.anyRequest().authenticated()
                //.antMatchers(HttpMethod.GET, "/admin").hasAuthority("scope:admin")
                //.antMatchers(HttpMethod.GET, "/admin/*").hasAuthority("scope:admin")
                //.antMatchers(HttpMethod.DELETE, "/admin/*").hasAuthority("scope:admin")
                //.antMatchers(HttpMethod.PUT, "/admin/*").hasAuthority("scope:admin")
                //.antMatchers(HttpMethod.POST, "/admin").hasAuthority("scope:admin")
    }


}