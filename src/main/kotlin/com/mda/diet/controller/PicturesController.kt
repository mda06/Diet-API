package com.mda.diet.controller

import com.mda.diet.service.PictureService
import org.springframework.format.annotation.DateTimeFormat
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.multipart.MultipartFile
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestParam
import java.time.LocalDate

@RestController
@RequestMapping("$prefix/pictures")
class PicturesController(val service: PictureService) {
    @PostMapping("/upload")
    fun handleFileUpload(pictures: List<MultipartFile>,
                            @RequestParam(name = "date", required = false)
                            @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)date: LocalDate?)
        = service.handleFileUpload(pictures, date)
}