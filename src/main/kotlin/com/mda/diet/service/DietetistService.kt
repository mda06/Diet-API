package com.mda.diet.service

import com.mda.diet.dto.DietetistAttachPatientDto
import com.mda.diet.error.CustomNotFoundException
import com.mda.diet.model.Dietetist
import com.mda.diet.repository.DietetistRepository
import com.mda.diet.repository.PatientRepository
import org.springframework.stereotype.Service

@Service
class DietetistService(val repository: DietetistRepository,
                       val patientRepository: PatientRepository) {
    fun findAll() = repository.findAll()

    fun addDietetist(dietetist: Dietetist)
            = repository.save(dietetist)

    fun updateDietetist(id: Long, dietetist: Dietetist): Dietetist {
        assert(id == dietetist.id)
        return repository.save(dietetist)
    }

    fun deleteAddress(id: Long)
            = repository.delete(id)

    fun getById(id: Long)
            = repository.findOne(id) ?: throw CustomNotFoundException("Not found dietetist with id $id")

    fun attachPatient(dto: DietetistAttachPatientDto) : Dietetist {
        val pat = patientRepository.findOne(dto.patient_id)
        val diet = repository.findOne(dto.diet_id)
        if(pat != null && diet != null) {
            pat.dietetistId = diet.id
            patientRepository.save(pat)
        } else {
            throw CustomNotFoundException("Not found patient or dietetist with id ${dto.patient_id}")
        }
        return diet
    }

    fun detachPatient(dto: DietetistAttachPatientDto) : Dietetist {
        val pat = patientRepository.findOne(dto.patient_id)
        val diet = repository.findOne(dto.diet_id)
        if(pat != null) {
            pat.dietetistId = null
            patientRepository.save(pat)
        } else {
            throw CustomNotFoundException("Not found patient with id ${dto.patient_id}")
        }
        return diet
    }

}