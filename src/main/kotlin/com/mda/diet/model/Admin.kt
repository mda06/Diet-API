package com.mda.diet.model

import java.time.LocalDate
import javax.persistence.Entity

@Entity
class Admin(id: Long = 0,
            firstName: String = "",
            middleName: String = "",
            lastName: String = "",
            email: String = "",
            phone: String = "",
            address: Address = Address(),
            gender: Gender? = null,
            created: LocalDate? = null,
            birthday: LocalDate? = null,
            var nickname: String = "")
    : Customer(id, firstName, middleName, lastName, email, phone, address, gender, created, birthday)