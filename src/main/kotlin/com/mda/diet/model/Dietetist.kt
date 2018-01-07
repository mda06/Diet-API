package com.mda.diet.model

import java.time.LocalDate
import javax.persistence.CascadeType
import javax.persistence.Entity
import javax.persistence.OneToMany

@Entity
class Dietetist(id: Long = 0,
                firstName: String = "",
                middleName: String = "",
                lastName: String = "",
                email: String = "",
                phone: String = "",
                address: Address = Address(),
                gender: Gender? = null,
                created: LocalDate? = null,
                birthday: LocalDate? = null,
                var vat: String = "",
                @OneToMany(mappedBy = "dietetistId", cascade = [(CascadeType.ALL)])
                var patients: MutableList<Patient> = arrayListOf())
    : Customer(id, firstName, middleName, lastName, email, phone, address, gender, created, birthday)