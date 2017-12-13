package com.mda.diet.repository

import com.mda.diet.model.Patient
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface PatientRepository: CrudRepository<Patient, Long> {
    fun getAllByDietetistId(id: Long) : List<Patient>
}