package com.mda.diet.service

import com.mda.diet.dto.MealPictureDto
import org.springframework.stereotype.Service
import org.springframework.web.multipart.MultipartFile
import java.time.LocalDate

@Service
class PictureService {
    fun handleFileUpload(pictures: List<MultipartFile>): List<MealPictureDto> {
        return try {
            val dtos = pictures.map { it -> MealPictureDto(0, LocalDate.now(), it.originalFilename) }
            //Save to model the DB
            //Save the pictures in a folder
            return dtos
        } catch (e: Exception) {
            //TODO: Send custom exception
            throw Exception("Failed to upload pictures")
        }
    }
}