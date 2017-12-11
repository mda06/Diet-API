package com.mda.diet.model

import javax.persistence.Entity

@Entity
class Dietetist(id: Long, firstName: String, middleName: String, lastName: String, email: String, phone: String, address: Address,
            var vat: String = "") //TODO add a list of patients
    : Customer(id, firstName, middleName, lastName, email, phone, address)