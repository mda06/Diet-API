package com.mda.diet.api.service

import com.mda.diet.error.CustomNotFoundException
import com.mda.diet.error.LoginException
import com.mda.diet.model.LoginAccess
import com.mda.diet.model.Maintenance
import com.mda.diet.model.MaintenanceState
import com.mda.diet.repository.LoginAccessRepository
import com.mda.diet.repository.MaintenanceRepository
import com.mda.diet.service.LoginAccessService
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.Mockito
import org.springframework.test.context.junit4.SpringRunner
import java.sql.Timestamp
import java.time.LocalDateTime
import kotlin.test.*


@RunWith(SpringRunner::class)
class LoginAccessServiceTest {

    init {
        System.setProperty("spring.config.name", "test")
        System.setProperty("spring.profiles.active", "test")
    }

    @Mock
    var repository: LoginAccessRepository? = null

    @Mock
    var maintenanceRepository: MaintenanceRepository? = null

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
        val loginAccess = LoginAccess(
                "auth0|5a38dd838d3cea7aad40e5ad",
                java.sql.Timestamp(1520255888000).toLocalDateTime(),
                null,
                java.sql.Timestamp(1520342288000).toLocalDateTime(),
                java.sql.Timestamp(1520255888000).toLocalDateTime(),
                false)
        Mockito.`when`(repository!!.save(Mockito.any<LoginAccess>())).thenAnswer {
            it.getArgumentAt(0, LoginAccess::class.java)
        }
        Mockito.`when`(repository!!.findOne(loginAccess.authId)).thenReturn(loginAccess)
        val login = service!!.onLogout(loginAccess.authId)
        assertEquals(loginAccess.authId, login.authId)
        assertEquals(loginAccess.isBlacklisted, login.isBlacklisted)
        assertTrue((Timestamp.valueOf(LocalDateTime.now()).time - Timestamp.valueOf(login.logOutTime).time) < 1000)
        assertTrue((Timestamp.valueOf(LocalDateTime.now()).time - Timestamp.valueOf(login.lastActivityTime).time) < 1000)
        assertEquals(java.sql.Timestamp(1520255888000).toLocalDateTime(), login.loginTime)
        assertEquals(java.sql.Timestamp(1520342288000).toLocalDateTime(), login.expirationTime)
    }

    @Test
    fun testAddActivityNotFound() {
        Mockito.`when`(repository!!.findOne(Mockito.any())).thenReturn(null)
        try {
            service!!.onLogout("auth0|uyvuvzkeoinon")
            fail("Must throw CustomNotFoundException when no login was found")
        } catch(ex: CustomNotFoundException) {
            assertEquals("No login access found with id: auth0|uyvuvzkeoinon", ex.message)
        }
    }

    @Test
    fun testAddActivitySuccess() {
        val loginAccess = LoginAccess(
                "auth0|5a38dd838d3cea7aad40e5ad",
                java.sql.Timestamp(1520255888000).toLocalDateTime(),
                null,
                java.sql.Timestamp(1520342288000).toLocalDateTime(),
                java.sql.Timestamp(1520255888000).toLocalDateTime(),
                false)
        Mockito.`when`(repository!!.save(Mockito.any<LoginAccess>())).thenAnswer {
            it.getArgumentAt(0, LoginAccess::class.java)
        }
        Mockito.`when`(repository!!.findOne(loginAccess.authId)).thenReturn(loginAccess)
        val login = service!!.addActivity(loginAccess.authId)
        assertTrue((Timestamp.valueOf(LocalDateTime.now()).time - Timestamp.valueOf(login.lastActivityTime).time) < 1000)
    }

    @Test
    fun testIsInMaintenanceFalse() {
        service!!.maintenance = null
        assertFalse(service!!.isInMaintenance())
    }

    @Test
    fun testPutInMaintenanceError() {
        service!!.maintenance = Maintenance()
        try {
            service!!.putInMaintenance("Test")
        }catch(ex: LoginException) {
            assertEquals("Cannot put in maintenance, it's already in maintenance !", ex.message)
        }
    }

    @Test
    fun testPutInMaintenanceWorking() {
        service!!.maintenance = null
        Mockito.`when`(maintenanceRepository!!.save(Mockito.any<Maintenance>())).thenAnswer {
            it.getArgumentAt(0, Maintenance::class.java)
        }
        val main = service!!.putInMaintenance("Filling products")
        assertTrue((Timestamp.valueOf(LocalDateTime.now()).time - Timestamp.valueOf(main.beginDate).time) < 1000)
        assertEquals(null, main.endDate)
        assertEquals("Filling products", main.reason)
        assertEquals(MaintenanceState.BEGIN, main.state)
    }

    @Test
    fun testRemoveMaintenanceError() {
        service!!.maintenance = null
        try {
            service!!.removeMaintenance()
        }catch(ex: LoginException) {
            assertEquals("It's not in maintenance !", ex.message)
        }
    }

    @Test
    fun testRemoveMaintenanceWorking() {
        service!!.maintenance = Maintenance(2, "Update users", LocalDateTime.of(2018, 3, 8, 11, 54, 0), null, MaintenanceState.BEGIN)
        Mockito.`when`(maintenanceRepository!!.save(Mockito.any<Maintenance>())).thenAnswer {
            it.getArgumentAt(0, Maintenance::class.java)
        }
        val main = service!!.removeMaintenance()
        assertEquals(2, main.id)
        assertEquals( LocalDateTime.of(2018, 3, 8, 11, 54, 0), main.beginDate)
        assertTrue((Timestamp.valueOf(LocalDateTime.now()).time - Timestamp.valueOf(main.endDate).time) < 1000)
        assertEquals("Update users", main.reason)
        assertEquals(MaintenanceState.END, main.state)
    }

    @Test
    fun testGetMaintenanceStatusWhenItsInMaintenance() {
        service!!.maintenance = Maintenance(3, "Update users", LocalDateTime.of(2018, 3, 8, 11, 54, 0), null, MaintenanceState.BEGIN)
        val main = service!!.getMaintenanceStatus()
        assertEquals(3, main.id)
        assertEquals( LocalDateTime.of(2018, 3, 8, 11, 54, 0), main.beginDate)
        assertEquals(null, main.endDate)
        assertEquals("Update users", main.reason)
        assertEquals(MaintenanceState.BEGIN, main.state)
    }

    @Test
    fun testGetMaintenanceStatusWhenRepoIsEmpty() {
        service!!.maintenance = null
        Mockito.`when`(maintenanceRepository!!.findFirstOrderById()).thenReturn(null)
        val main = service!!.getMaintenanceStatus()
        assertEquals(0, main.id)
        assertNull(main.beginDate)
        assertNull(main.endDate)
        assertEquals("", main.reason)
        assertEquals(MaintenanceState.NONE, main.state)
    }

    @Test
    fun testGetMaintenanceStatusWhenItsInRepo() {
        service!!.maintenance = null
        Mockito.`when`(maintenanceRepository!!.findFirstOrderById()).thenReturn(Maintenance(4, "Daily backup", LocalDateTime.of(2018, 3, 8, 11, 54, 0), null, MaintenanceState.BEGIN))
        val main = service!!.getMaintenanceStatus()
        assertEquals(4, main.id)
        assertEquals( LocalDateTime.of(2018, 3, 8, 11, 54, 0), main.beginDate)
        assertEquals(null, main.endDate)
        assertEquals("Daily backup", main.reason)
        assertEquals(MaintenanceState.BEGIN, main.state)
    }
}