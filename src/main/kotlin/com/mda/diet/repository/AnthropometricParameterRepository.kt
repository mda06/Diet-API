package com.mda.diet.repository

import com.mda.diet.model.AnthropometricParameter
import org.springframework.data.repository.CrudRepository

interface AnthropometricParameterRepository : CrudRepository<AnthropometricParameter, Long> {
    fun getAllByPatientId(id: Long) : List<AnthropometricParameter>
}