package com.mda.diet.service

import com.mda.diet.dto.MealPictureDto
import com.mda.diet.error.UploadFileException
import com.mda.diet.model.MealPicture
import com.mda.diet.model.Patient
import com.mda.diet.repository.MealPictureRepository
import org.springframework.stereotype.Service
import org.springframework.web.multipart.MultipartFile
import java.time.LocalDate

@Service
class PictureService(val repository: MealPictureRepository) {

    fun handleFileUpload(pictures: List<MultipartFile>, date: LocalDate?): List<MealPictureDto> {
        try {
            if(date == null) throw UploadFileException("No date was given")
            if(pictures.isEmpty()) throw  UploadFileException("No pictures was given")
            //Check patient !
            val patient: Patient? = null

            val models = repository.save(pictures.map {
                MealPicture(0, it.originalFilename, date, patient)
            })

            //Save the pictures in a folder
            //If a error occurs delete from the DB !

            return models.map { MealPictureDto(it) }
        } catch (e: Exception) {
            throw UploadFileException("Failed to upload pictures ${e.message}")
        }
    }
}