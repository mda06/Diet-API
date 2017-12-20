package com.mda.diet.controller


import com.mda.diet.model.Patient
import com.mda.diet.service.PatientService
import org.springframework.web.bind.annotation.*


@RestController
@RequestMapping("/patient")
class PatientController(val service: PatientService) {
   @GetMapping
    fun findAll() = service.findAll()

    @GetMapping("/{id}")
    fun getById(@PathVariable id: Long)
            = service.getById(id)

    @GetMapping("/dietetist/{id}")
    fun getByDiet(@PathVariable id: Long)
            =  service.getByDiet(id)

    @PostMapping
    fun addPatient(@RequestBody patient: Patient)
            = service.addPatient(patient)

    @PutMapping("/{id}")
    fun updatePatient(@PathVariable id: Long, @RequestBody patient: Patient)
            = service.updatePatient(id, patient)


    @DeleteMapping("/{id}")
    fun deletePatient(@PathVariable id: Long)
            = service.deletePatient(id)

}