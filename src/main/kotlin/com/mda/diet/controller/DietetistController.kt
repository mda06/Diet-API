package com.mda.diet.controller


import com.fasterxml.jackson.databind.node.ObjectNode
import com.mda.diet.model.Dietetist
import com.mda.diet.repository.DietetistRepository
import com.mda.diet.repository.PatientRepository
import org.springframework.web.bind.annotation.*


@RestController
@RequestMapping("/dietetist")
class DietetistController(
        val repository: DietetistRepository,
        val patientRepository: PatientRepository) {

    @GetMapping
    fun findAll() = repository.findAll()

    @PostMapping
    fun addDietetist(@RequestBody dietetist: Dietetist)
            = repository.save(dietetist)

    @PutMapping("/{id}")
    fun updateDietetist(@PathVariable id: Long, @RequestBody dietetist: Dietetist): Dietetist {
        assert(id == dietetist.id)
        return repository.save(dietetist)
    }

    @DeleteMapping("/{id}")
    fun deleteAddress(@PathVariable id: Long)
            = repository.delete(id)

    @GetMapping("/{id}")
    fun getById(@PathVariable id: Long)
            = repository.findOne(id)

    @PostMapping("/attach/{id}")
    fun attachPatient(@PathVariable id: Long, @RequestBody json: ObjectNode) : Dietetist {
        val pat = patientRepository.findOne(id)
        val diet = repository.findOne(json.get("diet_id").asLong())
        diet.patients.add(pat)
        repository.save(diet)
        patientRepository.save(pat)
        return diet
    }

    @PostMapping("/detach/{id}")
    fun detachPatient(@PathVariable id: Long, @RequestBody json: ObjectNode) : Dietetist {
        val pat = patientRepository.findOne(id)
        val diet = repository.findOne(json.get("diet_id").asLong())
        diet.patients.remove(pat)
        repository.save(diet)   //Save doesn't work
        return diet
    }

}
