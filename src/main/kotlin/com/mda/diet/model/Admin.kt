package com.mda.diet.model

import javax.persistence.Entity

@Entity
class Admin(id: Long = 0,
            firstName: String = "",
            middleName: String = "",
            lastName: String = "",
            email: String = "",
            phone: String = "",
            address: Address = Address(),
            var nickname: String = "")
    : Customer(id, firstName, middleName, lastName, email, phone, address)