package com.mda.diet.service

import com.mda.diet.model.Patient
import com.mda.diet.repository.PatientRepository
import org.springframework.stereotype.Service

@Service
class PatientService(val repository: PatientRepository) {
    fun findAll() = repository.findAll()

    fun getById(id: Long)
            = repository.findOne(id)

    fun getByDiet(id: Long)
            =  repository.getAllByDietetistId(id)

    fun addPatient(patient: Patient)
            = repository.save(patient)

    fun updatePatient(id: Long, patient: Patient) : Patient {
        assert(id == patient.id)
        return repository.save(patient)
    }

    fun deletePatient(id: Long)
            = repository.delete(id)
}