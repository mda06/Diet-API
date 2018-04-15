package com.mda.diet.controller

import com.mda.diet.service.PictureService
import org.springframework.format.annotation.DateTimeFormat
import org.springframework.web.bind.annotation.*
import org.springframework.web.multipart.MultipartFile
import java.time.LocalDate

@RestController
@RequestMapping("$prefix/pictures")
class PicturesController(val service: PictureService) {
    @PostMapping("/upload")
    fun handleFileUpload(pictures: List<MultipartFile>,
                            @RequestParam(name = "date", required = false)
                            @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)date: LocalDate?)
        = service.handleFileUpload(pictures, date)

    @GetMapping("/model")
    fun getMealPicturesModel(patient: Long?)
            = service.getMealPicturesModel(patient)
}