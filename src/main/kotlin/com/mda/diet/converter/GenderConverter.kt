package com.mda.diet.converter

import com.mda.diet.model.Gender
import javax.persistence.AttributeConverter
import javax.persistence.Converter

@Converter(autoApply = true)
class GenderConverter : AttributeConverter<Gender, String> {
    override fun convertToDatabaseColumn(gender: Gender) =
        when(gender) {
            Gender.FEMALE -> "F"
            Gender.MALE -> "M"
            Gender.OTHER -> "O"
        }

    override fun convertToEntityAttribute(sGender: String) =
        when(sGender) {
            "F" -> Gender.FEMALE
            "M" -> Gender.MALE
            "O" -> Gender.OTHER
            else -> Gender.OTHER
        }

}