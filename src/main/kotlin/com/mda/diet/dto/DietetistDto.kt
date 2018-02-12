package com.mda.diet.dto

import com.mda.diet.model.*
import java.time.LocalDate

class DietetistDto(val id: Long = 0,
                   val authId: String? = "",
                   val firstName: String = "",
                   val middleName: String = "",
                   val lastName: String = "",
                   val email: String = "",
                   val phone: String = "",
                   val address: Address = Address(),
                   val gender: Gender? = null,
                   val created: LocalDate? = null,
                   val birthday: LocalDate? = null,
                   val vat: String = "",
                   val patients: MutableList<Patient> = arrayListOf()) {
    constructor(diet: Dietetist) : this(diet.id, diet.authId, diet.firstName, diet.middleName, diet.lastName, diet.email, diet.phone,
            diet.address, diet.gender, diet.created, diet.birthday, diet.vat, diet.patients)
}