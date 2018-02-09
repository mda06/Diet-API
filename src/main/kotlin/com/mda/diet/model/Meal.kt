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
        @OneToMany(mappedBy = "meal", cascade = [CascadeType.ALL], orphanRemoval = true)
        var mealProducts: MutableList<MealProduct> = mutableListOf(),
        @ManyToOne
        @JoinColumn(name = "diet_id")
        var diet: Dietetist? = null)