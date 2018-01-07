package com.mda.diet.model

import javax.persistence.*


@Entity
class Address (
        @Id @GeneratedValue(strategy = GenerationType.AUTO)
        var id: Long = 0,
        var country: String = "",
        var postcode: Int = 0,
        var city: String = "",
        var street: String = "",
        var number: String = ""
)