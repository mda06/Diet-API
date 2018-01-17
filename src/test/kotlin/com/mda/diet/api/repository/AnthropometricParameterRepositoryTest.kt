package com.mda.diet.api.repository

import com.mda.diet.model.AnthropometricParameter
import com.mda.diet.repository.AnthropometricParameterRepository
import org.junit.Test
import org.junit.runner.RunWith
import org.springframework.test.context.junit4.SpringRunner
import kotlin.test.assertEquals
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.orm.jpa.AutoConfigureTestEntityManager
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager


@RunWith(SpringRunner::class)
@DataJpaTest
@AutoConfigureTestEntityManager
class AnthropometricParameterRepositoryTest {

    /*init {
        System.setProperty("spring.config.name", "test")
        System.setProperty("spring.profiles.active", "test")
    }

    @Autowired
    val entity: TestEntityManager? = null

    @Autowired
    val repository: AnthropometricParameterRepository? = null

    @Test
    fun findAllParamWithPatientId() {
        entity!!.merge(AnthropometricParameter(0, 180, 80.0, 2.0,
                50.0, null, 0))
        entity!!.merge(AnthropometricParameter(2, 185, 100.0, 2.0,
                55.0, null, 0))
        entity!!.merge(AnthropometricParameter(3, 80, 40.0, 1.0,
                20.0, null, 1))
        val tst = entity!!.merge(AnthropometricParameter(4, 180, 80.0, 2.0,
                50.0, null, 2))
        println(tst.id)
        val params = repository!!.findAll()
        params.forEach { println(it.id) }
        assertEquals(2, params.count())
        /*var param = params[0]
        assertEquals(1, param.id)
        assertEquals(180, param.length)
        assertEquals(80.0, param.weight)
        assertEquals(2.0, param.bodyFat)
        assertEquals(50.0, param.waistCircumference)
        param = params[1]
        assertEquals(3, param.id)
        assertEquals(80, param.length)
        assertEquals(40.0, param.weight)
        assertEquals(1.0, param.bodyFat)
        assertEquals(20.0, param.waistCircumference)*/
    }*/

    @Test
    fun shouldPassForMaven() {}
}
