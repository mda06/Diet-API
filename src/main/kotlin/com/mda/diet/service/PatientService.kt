package com.mda.diet.service

import com.mda.diet.model.Dietetist
import com.mda.diet.model.Patient
import com.mda.diet.repository.CustomerRepository
import com.mda.diet.repository.PatientRepository
import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.stereotype.Service

@Service
class PatientService(val repository: PatientRepository,
                     val customerRepository: CustomerRepository) {
    fun findAll() = repository.findAll()

    fun getById(id: Long)
            = repository.findOne(id)

    fun getByDiet(id: Long)
            =  repository.getAllByDietetistId(id)

    fun addPatient(patient: Patient): Patient {
        if(patient.dietetistId == 0L) {
            val customer = customerRepository.getByAuthId(SecurityContextHolder.getContext().authentication.principal.toString())
            //Test if customer is a dietetist
            patient.dietetistId = customer.id
        }
        return repository.save(patient)
    }

    fun updatePatient(id: Long, patient: Patient) : Patient {
        assert(id == patient.id)
        return repository.save(patient)
    }

    fun deletePatient(id: Long)
            = repository.delete(id)
}