package com.mda.diet.model

import javax.persistence.Entity

@Entity
class Patient(id: Long = 0,
              firstName: String = "",
              middleName: String = "",
              lastName: String = "",
              email: String = "",
              phone: String = "",
              address: Address = Address(),
            var extraInfo: String = "") //TODO: anthropometric parameters
    : Customer(id, firstName, middleName, lastName, email, phone, address)