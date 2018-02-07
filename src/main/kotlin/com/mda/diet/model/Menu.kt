package com.mda.diet.model

import org.springframework.data.jpa.convert.threeten.Jsr310JpaConverters
import java.time.LocalDate
import javax.persistence.*

@Entity
class Menu (
        @Id @GeneratedValue(strategy = GenerationType.AUTO)
        val id: Long = 0,
        @Convert(converter = Jsr310JpaConverters.LocalDateConverter::class)
        val date: LocalDate? = null,
        @OneToMany(mappedBy = "menu", cascade = [(CascadeType.ALL)])
        var meals: MutableList<Meal> = arrayListOf(),
        @ManyToOne
        @JoinColumn(name = "patient_id")
        val patient: Patient? = null)