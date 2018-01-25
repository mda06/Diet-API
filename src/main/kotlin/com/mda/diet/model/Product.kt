package com.mda.diet.model

import javax.persistence.*

@Entity
class Product(
        @Id
        var id: Long = 0,
        val imgUrl: String = "",
        @OneToMany(mappedBy = "productId", cascade = [CascadeType.MERGE], orphanRemoval = true)
        val translations: MutableList<ProductTranslation> = arrayListOf(),
        @ManyToMany(mappedBy = "favoriteProducts")
        val dietetists: MutableList<Dietetist> = arrayListOf(),
        @ManyToMany(mappedBy = "products")
        val meals: MutableList<Meal> = arrayListOf())