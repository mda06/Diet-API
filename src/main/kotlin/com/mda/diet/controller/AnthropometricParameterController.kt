package com.mda.diet.controller

import com.mda.diet.model.AnthropometricParameter
import com.mda.diet.repository.AnthropometricParameterRepository
import org.springframework.web.bind.annotation.*


@RestController
@RequestMapping("/param")
class AnthropometricParameterController(val repository: AnthropometricParameterRepository) {
    @GetMapping
    fun findAll() = repository.findAll()

    @GetMapping("/{id}")
    fun getById(@PathVariable id: Long)
            = repository.findOne(id)

    @GetMapping("/patient/{id}")
    fun getByPatient(@PathVariable id: Long)
            =  repository.getAllByPatientId(id)

    @PostMapping
    fun addAnthropometricParameter(@RequestBody param: AnthropometricParameter)
            = repository.save(param)

    @PutMapping("/{id}")
    fun updateAnthropometricParameter(@PathVariable id: Long, @RequestBody param: AnthropometricParameter) : AnthropometricParameter {
        assert(id == param.id)
        return repository.save(param)
    }

    @DeleteMapping("/{id}")
    fun deleteAnthropometricParameter(@PathVariable id: Long)
            = repository.delete(id)

}