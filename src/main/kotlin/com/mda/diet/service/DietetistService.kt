package com.mda.diet.service

import com.fasterxml.jackson.databind.node.ObjectNode
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
            = repository.findOne(id)

    fun attachPatient(json: ObjectNode) : Dietetist {
        val pat = patientRepository.findOne(json.get("patient_id").asLong())
        val diet = repository.findOne(json.get("diet_id").asLong())
        if(pat != null) {
            pat.dietetistId = diet.id
            patientRepository.save(pat)
        }
        return diet
    }

    fun detachPatient(json: ObjectNode) : Dietetist {
        val pat = patientRepository.findOne(json.get("patient_id").asLong())
        val diet = repository.findOne(json.get("diet_id").asLong())
        if(pat != null) {
            pat.dietetistId = null
            patientRepository.save(pat)
        }
        return diet
    }

}