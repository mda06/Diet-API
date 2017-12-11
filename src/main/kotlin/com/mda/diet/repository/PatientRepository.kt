package com.mda.diet.repository

import com.mda.diet.model.Patient
import org.springframework.data.repository.CrudRepository


interface PatientRepository: CrudRepository<Patient, Long>