package com.mda.diet.model

import com.fasterxml.jackson.annotation.JsonBackReference
import org.springframework.data.jpa.convert.threeten.Jsr310JpaConverters
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
              var extraInfo: String = "",
              @Convert(converter = Jsr310JpaConverters.LocalDateConverter::class)
              var created: LocalDate? = null,
              @Convert(converter = Jsr310JpaConverters.LocalDateConverter::class)
              var birthday: LocalDate? = null,
              @ManyToOne
              @JoinColumn(name = "dietetist_id")
              @JsonBackReference
              var dietetist: Dietetist? = null) //TODO: anthropometric parameters and activities
    : Customer(id, firstName, middleName, lastName, email, phone, address)