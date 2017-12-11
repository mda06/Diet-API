package com.mda.diet.model

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
        @OneToOne(cascade = arrayOf(CascadeType.ALL))
        @JoinColumn(name = "adr_id")
        var address: Address = Address()
        //TODO create user class to connect
)