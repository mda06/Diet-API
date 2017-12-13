package com.mda.diet.model

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
                var vat: String = "",
                @OneToMany(mappedBy = "dietetist", cascade = [(CascadeType.ALL)])
                var patients: MutableList<Patient> = arrayListOf())
    : Customer(id, firstName, middleName, lastName, email, phone, address) {
}