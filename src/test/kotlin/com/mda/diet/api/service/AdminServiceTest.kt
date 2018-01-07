package com.mda.diet.api.service


import com.mda.diet.error.CustomNotFoundException
import org.junit.Test
import org.junit.runner.RunWith
import com.mda.diet.model.Admin
import com.mda.diet.repository.AdminRepository
import com.mda.diet.service.AdminService
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.Mockito
import org.springframework.test.context.junit4.SpringRunner
import kotlin.test.*


@RunWith(SpringRunner::class)
class AdminServiceTest {

    @Mock
    var repository: AdminRepository? = null

    @InjectMocks
    var service: AdminService? = null

    @Test
    fun testFindAdminShouldPass() {
        val adminIn = Admin(1, "MDA", "Rodri", "Copp")
        Mockito.`when`(repository!!.findOne(1)).thenReturn(adminIn)
        val admin = service!!.getById(1)
        assertEquals(1, admin.id)
        assertEquals("MDA", admin.firstName)
        assertEquals("Rodri", admin.middleName)
        assertEquals("Copp", admin.lastName)
    }

    @Test
    fun testNotAdminShouldThrowError() {
        try {
            service!!.getById(2)
        } catch(ex: CustomNotFoundException) {
            assertEquals("Not found admin with id 2", ex.message!!)
        }
    }

    @Test
    fun testGetAllShouldReturnCorrectNumber() {
        Mockito.`when`(repository!!.findAll()).thenReturn(listOf(Admin(), Admin(), Admin()))
        val nb = service!!.findAll().count()
        assertEquals(3, nb)
    }

}
