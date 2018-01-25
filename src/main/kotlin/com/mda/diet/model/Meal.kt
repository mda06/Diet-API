package com.mda.diet.model

import javax.persistence.*

@Entity
class Meal (
        @Id @GeneratedValue(strategy = GenerationType.AUTO)
        val id: Long = 0,
        val name: String = "",
        val extraInfo: String = "",
        val score: Int = 0,
        val comment: String = "",
        @ManyToOne
        @JoinColumn(name = "menu_id")
        var menu: Menu? = null,
        @ManyToMany(cascade = [CascadeType.MERGE])
        @JoinTable(
                name="meal_products",
                joinColumns = [(JoinColumn(name = "meal_id"))],
                inverseJoinColumns = [(JoinColumn(name = "product_id"))])
        val products:  MutableList<Product> = arrayListOf())