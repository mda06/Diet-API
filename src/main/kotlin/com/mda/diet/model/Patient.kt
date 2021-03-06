package com.mda.diet.model

import com.fasterxml.jackson.annotation.JsonBackReference
import java.time.LocalDate
import javax.persistence.*

@Entity
class Patient(id: Long = 0,
              firstName: String = "",
              middleName: String = "",
              lastName: String = "",
              email: String = "",
              phone: String = "",
              address: Address = Address(),
              gender: Gender? = null,
              created: LocalDate? = null,
              birthday: LocalDate? = null,
              var extraInfo: String = "",
              var dietetistId: Long? = null,
              @OneToMany(mappedBy = "patientId", cascade = [(CascadeType.ALL)])
              var anthropometricParameters: MutableList<AnthropometricParameter> = arrayListOf())
    : Customer(id, firstName, middleName, lastName, email, phone, address, gender, created, birthday)