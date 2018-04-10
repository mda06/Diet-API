package com.mda.diet.controller

import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import jdk.nashorn.internal.codegen.OptimisticTypesPersistence.store
import org.springframework.web.multipart.MultipartFile
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.PostMapping



@RestController
@RequestMapping("$prefix/pictures")
class PicturesController {
    @PostMapping("/upload")
    fun handleFileUpload(pictures: MultipartFile): ResponseEntity<String> {
        var message: String
        return try {
            //storageService.store(pictures)
            //files.add(pictures.originalFilename)

            message = "You successfully uploaded " + pictures.originalFilename + "!"
            ResponseEntity.status(HttpStatus.OK).body(message)
        } catch (e: Exception) {
            message = "FAIL to upload " + pictures.originalFilename + "!"
            ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(message)
        }

    }
}