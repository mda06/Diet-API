package com.mda.diet.controller

import com.mda.diet.service.ReportService
import org.springframework.web.bind.annotation.*
import org.springframework.http.MediaType

@RestController
@RequestMapping("$prefix/report")
class ReportController (val service: ReportService) {

    @GetMapping("/menu/")
    fun getMenuReport(lang: String?, id: Long?) = service.getMenuReport(id, lang)

    @GetMapping("/pdf/patient/{id}", produces = [MediaType.APPLICATION_PDF_VALUE])
    fun getPatientPdf(@PathVariable id: Long?) = service.getPatientPdf(id)

}