package com.mda.diet.controller

import com.mda.diet.service.PictureService
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.multipart.MultipartFile
import org.springframework.web.bind.annotation.PostMapping

@RestController
@RequestMapping("$prefix/pictures")
class PicturesController(val service: PictureService) {
    @PostMapping("/upload")
    fun handleFileUpload(pictures: List<MultipartFile>)
        = service.handleFileUpload(pictures)
}