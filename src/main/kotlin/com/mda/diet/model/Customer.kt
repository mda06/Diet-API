package com.mda.diet.model

import com.mda.diet.converter.GenderConverter
import org.springframework.data.jpa.convert.threeten.Jsr310JpaConverters
import java.time.LocalDate
import javax.persistence.*

@Entity
abstract class Customer (
        @Id @GeneratedValue(strategy = GenerationType.AUTO)
        var id: Long = 0,
        var firstName: String = "",
        var middleName: String = "",
        var lastName: String = "",
        var email: String = "",
        var phone: String = "",
        @OneToOne(cascade = [(CascadeType.ALL)])
        @JoinColumn(name = "adr_id")
        var address: Address = Address(),
        @Convert(converter = GenderConverter::class)
        var gender: Gender? = null,
        @Convert(converter = Jsr310JpaConverters.LocalDateConverter::class)
        var created: LocalDate? = null,
        @Convert(converter = Jsr310JpaConverters.LocalDateConverter::class)
        var birthday: LocalDate? = null
        //TODO create user class to connect
)