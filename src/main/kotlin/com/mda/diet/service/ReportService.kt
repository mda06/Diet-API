package com.mda.diet.service

import com.mda.diet.dto.NutrimentDto
import com.mda.diet.dto.ReportMenuDto
import com.mda.diet.error.CustomNotFoundException
import com.mda.diet.repository.MenuRepository
import com.mda.diet.repository.PatientRepository
import org.springframework.stereotype.Service
import org.springframework.core.io.InputStreamResource
import org.springframework.http.HttpHeaders
import org.springframework.http.MediaType
import org.springframework.http.ResponseEntity


@Service
class ReportService(val repository: MenuRepository,
                    val patientRepository: PatientRepository) {

    fun getMenuReport(id: Long?, lang: String?): ReportMenuDto {
        val menu = repository.findOne(id)?: throw CustomNotFoundException("Not found menu with id $id")
        val macros = HashMap<String, Pair<Double, String>>()
        val micros = HashMap<String, Pair<Double, String>>()
        menu.meals.forEach {
            it.mealProducts.forEach {
                val quantity = it.quantity
                val pt = it.product?.translations?.firstOrNull { it.language == lang }
                        ?: throw CustomNotFoundException("Not found product in $lang")
                pt.micros.forEach {
                    if(micros.containsKey(it.name)) {
                        val value = micros[it.name]!!.first + it.value / 100 * quantity
                        micros.put(it.name, Pair(value, it.unit))
                    } else {
                        micros.put(it.name, Pair(it.value / 100 * quantity, it.unit))
                    }
                }
                pt.macros.forEach {
                    if(macros.containsKey(it.name)) {
                        val value = macros[it.name]!!.first + it.value / 100 * quantity
                        macros.put(it.name, Pair(value, it.unit))
                    } else {
                        macros.put(it.name, Pair(it.value / 100 * quantity, it.unit))
                    }
                }
            }
        }

        val macrosLst = macros.map { NutrimentDto(it.key, it.value.first, it.value.second) }
        val microsLst = micros.map { NutrimentDto(it.key, it.value.first, it.value.second) }
        return ReportMenuDto(menu.date, macrosLst, microsLst)
    }

    fun getPatientPdf(id: Long?): ResponseEntity<InputStreamResource> {
        val patient = patientRepository.findOne(id) ?: throw CustomNotFoundException("Not found patient with id $id")

        val bis = GeneratePdfReport().patientReport(patient)

        val headers = HttpHeaders()
        headers.add("Content-Disposition", "inline; filename=citiesreport.pdf")

        return ResponseEntity
                .ok()
                .headers(headers)
                .contentType(MediaType.APPLICATION_PDF)
                .body(InputStreamResource(bis))
    }

}