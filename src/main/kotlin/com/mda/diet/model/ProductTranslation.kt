package com.mda.diet.model

import javax.persistence.*

@Entity
@Table(uniqueConstraints = [(UniqueConstraint(name = "language_productId", columnNames = ["language", "product_id"]))])
class ProductTranslation(
        @Id @GeneratedValue(strategy = GenerationType.AUTO)
        val id: Long = 0,
        val language: String = "",
        val name: String = "",
        @Column(name = "product_id")
        val productId: Long = 0,
        @OneToMany(cascade = [(CascadeType.ALL)], orphanRemoval = true)
        val units: MutableList<Nutriment> = arrayListOf(),
        @OneToMany(cascade = [(CascadeType.ALL)], orphanRemoval = true)
        val macros: MutableList<Nutriment> = arrayListOf(),
        @OneToMany(cascade = [(CascadeType.ALL)], orphanRemoval = true)
        val micros: MutableList<Nutriment> = arrayListOf())