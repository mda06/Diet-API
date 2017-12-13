package com.mda.diet.controller


import com.mda.diet.model.Patient
import com.mda.diet.repository.PatientRepository
import org.springframework.web.bind.annotation.*


@RestController
@RequestMapping("/patient")
class PatientController(val repository: PatientRepository) {
   @GetMapping
    fun findAll() = repository.findAll()

    @GetMapping("/{id}")
    fun getById(@PathVariable id: Long)
            = repository.findOne(id)

    @GetMapping("/dietetist/{id}")
    fun getByDiet(@PathVariable id: Long)
            =  repository.getAllByDietetistId(id)

    @PostMapping
    fun addPatient(@RequestBody patient: Patient)
            = repository.save(patient)

    @PutMapping("/{id}")
    fun updatePatient(@PathVariable id: Long, @RequestBody patient: Patient) : Patient {
        assert(id == patient.id)
        return repository.save(patient)
    }

    @DeleteMapping("/{id}")
    fun deletePatient(@PathVariable id: Long)
            = repository.delete(id)

}