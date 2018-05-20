package com.mda.diet.controller

import com.mda.diet.service.PictureService
import org.springframework.format.annotation.DateTimeFormat
import org.springframework.http.HttpHeaders
import org.springframework.http.MediaType
import org.springframework.web.bind.annotation.*
import org.springframework.web.multipart.MultipartFile
import java.time.LocalDate
import org.springframework.util.StringUtils.getFilename
import org.springframework.http.ResponseEntity



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

    @GetMapping("/{id}", produces = [MediaType.IMAGE_PNG_VALUE, MediaType.IMAGE_JPEG_VALUE])
    fun getMealPicture(@PathVariable id: Long): ResponseEntity<Any>? {
        val file =  service.getMealPicture(id)
        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + file.filename + "\"")
                .body<Any>(file)
    }

    @DeleteMapping("/{id}")
    fun deleteMealPicture(@PathVariable id: Long)
            = service.deleteMealPicture(id)

}