package com.mda.diet.model

import java.time.LocalDate
import javax.persistence.*

@Entity
class Menu (
        @Id @GeneratedValue(strategy = GenerationType.AUTO)
        val id: Long = 0,
        val name: String = "",
        val date: LocalDate? = null,
        @OneToMany(mappedBy = "menu", cascade = [(CascadeType.ALL)])
        var meals: MutableList<Meal> = arrayListOf(),
        @ManyToOne
        @JoinColumn(name = "patient_id")
        val patient: Patient? = null)