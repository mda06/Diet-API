package com.mda.diet.model

import javax.persistence.Entity

@Entity
class Patient(id: Long, firstName: String, middleName: String, lastName: String, email: String, phone: String, address: Address,
            var extraInfo: String = "") //TODO: Add activities and anthropometric parameters
    : Customer(id, firstName, middleName, lastName, email, phone, address)