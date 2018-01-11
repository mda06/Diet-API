package com.mda.diet.model

import javax.persistence.*

@Entity
class ProductTranslation(
        @Id @GeneratedValue(strategy = GenerationType.AUTO)
        val id: Long = 0,
        val language: String = "",
        val name: String = "",
        val productId: Long = 0,
        @OneToMany(mappedBy = "productTranslation", cascade = [(CascadeType.ALL)], orphanRemoval = true)
        val units: MutableList<Nutriment> = arrayListOf(),
        @OneToMany(mappedBy = "productTranslation", cascade = [(CascadeType.ALL)], orphanRemoval = true)
        val macros: MutableList<Nutriment> = arrayListOf(),
        @OneToMany(mappedBy = "productTranslation", cascade = [(CascadeType.ALL)], orphanRemoval = true)
        val micros: MutableList<Nutriment> = arrayListOf())