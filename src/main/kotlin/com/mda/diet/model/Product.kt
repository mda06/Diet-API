package com.mda.diet.model

import javax.persistence.*

@Entity
class Product(
        @Id @GeneratedValue(strategy = GenerationType.AUTO)
        val id: Long = 0,
        val name: String = "",
        val imgUrl: String = "",
        @OneToMany(cascade = [(CascadeType.ALL)], orphanRemoval = true)
        val units: MutableList<Nutriment> = arrayListOf(),
        @OneToMany(cascade = [(CascadeType.ALL)], orphanRemoval = true)
        val macros: MutableList<Nutriment> = arrayListOf(),
        @OneToMany(cascade = [(CascadeType.ALL)], orphanRemoval = true)
        val micros: MutableList<Nutriment> = arrayListOf())