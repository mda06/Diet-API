package com.mda.diet.service

import com.mda.diet.model.AnthropometricParameter
import com.mda.diet.repository.AnthropometricParameterRepository
import org.springframework.stereotype.Service

@Service
class AnthropometricParameterService(val repository: AnthropometricParameterRepository) {
    fun findAll() = repository.findAll()

    fun getById(id: Long)
            = repository.findOne(id)

    fun getByPatient(id: Long)
            =  repository.getAllByPatientId(id)

    fun addAnthropometricParameter(param: AnthropometricParameter)
            = repository.save(param)

    fun updateAnthropometricParameter(id: Long, param: AnthropometricParameter) : AnthropometricParameter {
        assert(id == param.id)
        return repository.save(param)
    }

    fun deleteAnthropometricParameter(id: Long)
            = repository.delete(id)
}