package com.mda.diet.model

import java.time.LocalDate
import javax.persistence.*

@Entity
class Dietetist(id: Long = 0,
                firstName: String = "",
                middleName: String = "",
                lastName: String = "",
                email: String = "",
                phone: String = "",
                address: Address = Address(),
                gender: Gender? = null,
                created: LocalDate? = null,
                birthday: LocalDate? = null,
                var vat: String = "",
                @OneToMany(mappedBy = "dietetistId", cascade = [(CascadeType.ALL)])
                var patients: MutableList<Patient> = arrayListOf(),
                @ManyToMany(cascade = [CascadeType.MERGE])
                @JoinTable(
                        name="diet_fav_products",
                        joinColumns = [(JoinColumn(name = "diet_id"))],
                        inverseJoinColumns = [(JoinColumn(name = "product_id"))])
                val favoriteProducts: MutableList<Product> = arrayListOf(),
                @OneToMany(mappedBy = "diet", cascade = [CascadeType.ALL], orphanRemoval = true)
                var mealTemplates: MutableList<Meal> = mutableListOf())
    : Customer(id, firstName, middleName, lastName, email, phone, address, gender, created, birthday)