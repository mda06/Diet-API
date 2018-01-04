package com.mda.diet.api.service


import com.mda.diet.error.CustomNotFoundException
import org.junit.Test
import org.junit.runner.RunWith
import com.mda.diet.model.Address
import com.mda.diet.repository.AddressRepository
import com.mda.diet.service.AddressService
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.Mockito
import org.springframework.test.context.junit4.SpringRunner
import kotlin.test.*


@RunWith(SpringRunner::class)
class AddressServiceTest {

    @Mock
    var repository: AddressRepository? = null

    @InjectMocks
    var service: AddressService? = null

    @Test
    fun testFindAddressShouldPass() {
        val adrIn = Address(1, "Belgium", 1080, "Brussels","Vandernoot", "37");
        Mockito.`when`(repository!!.findOne(1)).thenReturn(adrIn)
        val adr = service!!.getById(1)
        assertEquals(adr.id, 1)
        assertEquals(adr.country, "Belgium")
        assertEquals(adr.postcode, 1080)
        assertEquals(adr.city, "Brussels")
        assertEquals(adr.street, "Vandernoot")
        assertEquals(adr.number, "37")
    }

    @Test
    fun testNotAddressShouldThrowError() {
        try {
            service!!.getById(2)
        } catch(ex: CustomNotFoundException) {
            assertEquals("Not found address with id 2", ex.message!!)
        }
    }

    @Test
    fun testGetAllShouldReturnCorrectNumber() {
        Mockito.`when`(repository!!.findAll()).thenReturn(listOf(Address(), Address(), Address()))
        val nb = service!!.findAll().count()
        assertEquals(3, nb)
    }

}
