package com.mda.diet.controller

import com.mda.diet.model.AnthropometricParameter
import com.mda.diet.service.AnthropometricParameterService
import org.springframework.web.bind.annotation.*


@RestController
@RequestMapping("$prefix/param")
class AnthropometricParameterController(val service: AnthropometricParameterService) {
    @GetMapping
    fun findAll() = service.findAll()

    @GetMapping("/{id}")
    fun getById(@PathVariable id: Long)
            = service.getById(id)

    @GetMapping("/patient/{id}")
    fun getByPatient(@PathVariable id: Long)
            =  service.getByPatient(id)

    @PostMapping
    fun addAnthropometricParameter(@RequestBody param: AnthropometricParameter)
            = service.addAnthropometricParameter(param)

    @PutMapping("/{id}")
    fun updateAnthropometricParameter(@PathVariable id: Long, @RequestBody param: AnthropometricParameter)
            = service.updateAnthropometricParameter(id, param)


    @DeleteMapping("/{id}")
    fun deleteAnthropometricParameter(@PathVariable id: Long)
            = service.deleteAnthropometricParameter(id)

}