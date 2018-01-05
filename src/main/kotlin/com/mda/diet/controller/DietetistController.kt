package com.mda.diet.controller


import com.mda.diet.dto.DietetistAttachPatientDto
import com.mda.diet.model.Dietetist
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
    fun attachPatient(@RequestBody dto: DietetistAttachPatientDto)
        = service.attachPatient(dto)

    @PostMapping("/detach")
    fun detachPatient(@RequestBody dto: DietetistAttachPatientDto)
        = service.detachPatient(dto)

}
