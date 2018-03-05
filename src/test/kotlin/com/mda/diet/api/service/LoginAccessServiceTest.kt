package com.mda.diet.api.service

import com.mda.diet.error.CustomNotFoundException
import com.mda.diet.model.LoginAccess
import com.mda.diet.repository.LoginAccessRepository
import com.mda.diet.service.LoginAccessService
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.Mockito
import org.springframework.test.context.junit4.SpringRunner
import javax.security.auth.login.LoginException
import kotlin.test.assertEquals
import kotlin.test.fail


@RunWith(SpringRunner::class)
class LoginAccessServiceTest {

    init {
        System.setProperty("spring.config.name", "test")
        System.setProperty("spring.profiles.active", "test")
    }

    @Mock
    var repository: LoginAccessRepository? = null

    @InjectMocks
    var service: LoginAccessService? = null

    @Test
    fun testLoginInvalidToken() {
        try {
            service!!.onLogin("kgvzakejhbljzhb.ezilblubhyaz-zarfrzr")
            fail("Must throw LoginException when no valid token given")
        } catch(ex: LoginException) {
            assertEquals("Not a valid token given: kgvzakejhbljzhb.ezilblubhyaz-zarfrzr", ex.message)
        }
    }

    @Test
    fun testLoginSuccess() {
        Mockito.`when`(repository!!.save(Mockito.any<LoginAccess>())).thenAnswer {
            it.getArgumentAt(0, LoginAccess::class.java)
        }
        val login = service!!.onLogin("eyJ0eXAiOiJKV1QiLCJhbGciOiJSUzI1NiIsImtpZCI6Ik56ZzRNVUZGUkRRelFUTTBNVVUxUlRJME1USkVPVEUyUlRNMlJVVkNNREJFTWpRNE9Ua3lSQSJ9.eyJpc3MiOiJodHRwczovL21kYXRlc3QuZXUuYXV0aDAuY29tLyIsInN1YiI6ImF1dGgwfDVhMzhkZDgzOGQzY2VhN2FhZDQwZTVhZCIsImF1ZCI6WyJodHRwczovL2RpZXQtbWFuYWdlbWVudC5jb20iLCJodHRwczovL21kYXRlc3QuZXUuYXV0aDAuY29tL3VzZXJpbmZvIl0sImlhdCI6MTUyMDI1NTg4OCwiZXhwIjoxNTIwMzQyMjg4LCJhenAiOiI1bm5SWFVpV3F4OWNNUzY1b0FOV01hUDN4ZUUxNlZBMSIsInNjb3BlIjoib3BlbmlkIHByb2ZpbGUgZW1haWwgYWRkcmVzcyBwaG9uZSBzY29wZTpkaWV0IiwiZ3R5IjoicGFzc3dvcmQifQ.JUhL5MtjOIBNSWCEq5KUr9tds_CnKBmr7xIBEBqyNaFBjN74ZPMmrTJF29N_vO4__tcx1pDfR45xliGmSnAkx1cAzZGG0pc8mdkBP2RIKRGG2ko_DZEUb2cSK8h1jehksBxa5IgQmsEmBgfjtoxw7aB4pi7GtQGf4ZemVccqBBE-z3qIDd0KG-8khIdeAJGLrl40yJ_eYJuowjP5qsVoIWU2e6r37-wjeOhLElOv61sF33kYMU1e1cIRMTv4LDdTc7A1PFOAbjreM2y2t_pc_O5UQygElSG-avEasyTtx-Kf3JiUMolOSZf-vBhulUe2DfosuU-tyZTaSPsqcmtCYg")
        assertEquals("auth0|5a38dd838d3cea7aad40e5ad", login.authId)
        assertEquals(false, login.isBlacklisted)
        assertEquals(null, login.logOutTime)
        assertEquals(java.sql.Timestamp(1520255888000).toLocalDateTime(), login.lastActivityTime)
        assertEquals(java.sql.Timestamp(1520255888000).toLocalDateTime(), login.loginTime)
        assertEquals(java.sql.Timestamp(1520342288000).toLocalDateTime(), login.expirationTime)
    }

    @Test
    fun testLogoutNotFound() {
        Mockito.`when`(repository!!.findOne("auth0|uyvuvzkeoinon")).thenReturn(null)
        try {
            service!!.onLogout("auth0|uyvuvzkeoinon")
            fail("Must throw CustomNotFoundException when no login was found")
        } catch(ex: CustomNotFoundException) {
            assertEquals("No login access found with id: auth0|uyvuvzkeoinon", ex.message)
        }
    }

    @Test
    fun testLogoutSuccess() {
        Mockito.`when`(repository!!.findOne("auth0|uyvuvzkeoinon")).thenReturn(null)
        try {
            service!!.onLogout("auth0|uyvuvzkeoinon")
            fail("Must throw CustomNotFoundException when no login was found")
        } catch(ex: CustomNotFoundException) {
            assertEquals("No login access found with id: auth0|uyvuvzkeoinon", ex.message)
        }
    }

}