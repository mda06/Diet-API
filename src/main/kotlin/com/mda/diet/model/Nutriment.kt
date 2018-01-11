package com.mda.diet.model

import com.fasterxml.jackson.annotation.JsonBackReference
import javax.persistence.*

@Entity
class Nutriment(
        @Id @GeneratedValue(strategy = GenerationType.AUTO)
        val id: Long = 0,
        val name: String = "",
        val value: Double = 0.0,
        val unit: String = "",
        @ManyToOne(cascade = [CascadeType.ALL])
        @JsonBackReference
        var productTranslation: ProductTranslation = ProductTranslation())