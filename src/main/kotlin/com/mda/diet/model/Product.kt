package com.mda.diet.model

import javax.persistence.*

@Entity
class Product(
        @Id @GeneratedValue(strategy = GenerationType.AUTO)
        val id: Long = 0,
        val name: String = "",
        val imgUrl: String = "",
        @OneToMany(mappedBy = "productId", cascade = [(CascadeType.ALL)])
        val units: List<Nutriment>,
        @OneToMany(mappedBy = "productId", cascade = [(CascadeType.ALL)])
        val macros: List<Nutriment>,
        @OneToMany(mappedBy = "productId", cascade = [(CascadeType.ALL)])
        val micros: List<Nutriment>)