package com.mda.diet.model

import java.io.Serializable
import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.JoinColumn
import javax.persistence.ManyToOne

@Entity
class MealProduct(
        @Id
        @ManyToOne
        @JoinColumn(name = "meal_id")
        var meal: Meal?,
        @Id
        @ManyToOne
        @JoinColumn(name = "product_id")
        val product: Product,
        val quantity: Int): Serializable