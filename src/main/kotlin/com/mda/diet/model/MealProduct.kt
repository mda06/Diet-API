package com.mda.diet.model

import java.io.Serializable
import javax.persistence.*

@Entity
class MealProduct(
        @Id @GeneratedValue(strategy = GenerationType.AUTO)
        val id: Long? = 0,
        @ManyToOne
        @JoinColumn(name = "meal_id")
        var meal: Meal? = null,
        @ManyToOne
        @JoinColumn(name = "product_id")
        val product: Product? = null,
        val quantity: Int = 0): Serializable