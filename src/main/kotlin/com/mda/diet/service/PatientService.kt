package com.mda.diet.service

import com.mda.diet.model.AnthropometricParameter
import com.mda.diet.model.Patient
import com.mda.diet.repository.AnthropometricParameterRepository
import com.mda.diet.repository.CustomerRepository
import com.mda.diet.repository.PatientRepository
import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.stereotype.Service

@Service
class PatientService(val repository: PatientRepository,
                     val customerRepository: CustomerRepository,
                     val paramRepository: AnthropometricParameterRepository) {
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
        if(patient.id == 0L) {
            //The param needs the id of the patient
            //But the id is only generated here so we first save the patient and after that the params
            val params = patient.anthropometricParameters
            val paramsReturn = arrayListOf<AnthropometricParameter>()
            patient.anthropometricParameters = arrayListOf()
            val patientReturn = repository.save(patient)
            for (param in params) {
                param.patientId = patientReturn.id
                paramsReturn.add(paramRepository.save(param))
            }
            //After that we put the array back
            patientReturn.anthropometricParameters = paramsReturn
            return patientReturn
        } else {
            return repository.save(patient);
        }
    }

    fun updatePatient(id: Long, patient: Patient) : Patient {
        assert(id == patient.id)
        return repository.save(patient)
    }

    fun deletePatient(id: Long)
            = repository.delete(id)
}