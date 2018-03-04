package com.mda.diet.controller

import com.mda.diet.service.ReportService
import org.springframework.web.bind.annotation.*


@RestController
@RequestMapping("$prefix/report")
class ReportController (val service: ReportService) {

    @GetMapping("/menu/")
    fun getMenuReport(lang: String?, id: Long?) = service.getMenuReport(id, lang)

}