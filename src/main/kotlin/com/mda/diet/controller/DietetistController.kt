package com.mda.diet.controller


import com.fasterxml.jackson.databind.node.ObjectNode
import com.mda.diet.model.Dietetist
import com.mda.diet.repository.DietetistRepository
import com.mda.diet.repository.PatientRepository
import com.mda.diet.service.DietetistService
import org.springframework.web.bind.annotation.*


@RestController
@RequestMapping("/dietetist")
class DietetistController(val service: DietetistService) {

    @GetMapping
    fun findAll() = service.findAll()

    @PostMapping
    fun addDietetist(@RequestBody dietetist: Dietetist)
            = service.addDietetist(dietetist)

    @PutMapping("/{id}")
    fun updateDietetist(@PathVariable id: Long, @RequestBody dietetist: Dietetist)
            = service.updateDietetist(id, dietetist)

    @DeleteMapping("/{id}")
    fun deleteAddress(@PathVariable id: Long)
            = service.deleteAddress(id)

    @GetMapping("/{id}")
    fun getById(@PathVariable id: Long)
            = service.getById(id)

    @PostMapping("/attach")
    fun attachPatient(@RequestBody json: ObjectNode)
        = service.attachPatient(json)

    @PostMapping("/detach")
    fun detachPatient(@RequestBody json: ObjectNode)
        = service.detachPatient(json)

}
