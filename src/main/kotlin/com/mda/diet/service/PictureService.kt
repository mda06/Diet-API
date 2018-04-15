package com.mda.diet.service

import com.mda.diet.dto.MealPictureDto
import com.mda.diet.error.UploadFileException
import com.mda.diet.model.MealPicture
import com.mda.diet.model.Patient
import com.mda.diet.repository.CustomerRepository
import com.mda.diet.repository.MealPictureRepository
import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.stereotype.Service
import org.springframework.web.multipart.MultipartFile
import java.io.File
import java.nio.file.Files
import java.time.LocalDate

@Service
class PictureService(val repository: MealPictureRepository,
                     val customerRepository: CustomerRepository) {

    val rootLocation = System.getProperty("user.home")!! + "/diet-api/"

    fun handleFileUpload(pictures: List<MultipartFile>, date: LocalDate?): List<MealPictureDto> {
        try {
            if(date == null) throw UploadFileException("No date was given")
            if(pictures.isEmpty()) throw  UploadFileException("No pictures was given")
            //Check patient !
            val customer = customerRepository.getByAuthId(SecurityContextHolder.getContext().authentication.principal.toString())
                    as? Patient ?: throw UploadFileException("The current customer is not a patient !")

            val models = repository.save(pictures.map {
                MealPicture(0, it.originalFilename, date, customer)
            })

            try {
                val patientDir = customer.authId?.replace("|", "")!!
                createDirectoriesIfNotExist(patientDir)
                pictures.forEach {
                    Files.copy(it.inputStream, File("$rootLocation/$patientDir/${it.originalFilename}").toPath())
                }
            } catch(ex: Exception)
            {
                //If a error occurs delete from the DB !
                repository.delete(models)
                throw UploadFileException("Failed to upload pictures: ${ex.javaClass.name} - ${ex.message}")
            }

            return models.map { MealPictureDto(it) }
        } catch (e: Exception) {
            throw UploadFileException("Failed to upload pictures: ${e.javaClass.name} - ${e.message}")
        }
    }

    fun createDirectoriesIfNotExist(subDir: String)
    {
        val rootDirectory = File(rootLocation)
        if(!rootDirectory.exists())
            rootDirectory.mkdir()
        val uploadDir = rootLocation + subDir
        val directory = File(uploadDir)
        if(!directory.exists())
            directory.mkdir()
    }
}