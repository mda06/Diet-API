package com.mda.diet.model

import javax.persistence.*

@Entity
class Product(
        @Id
        var id: Long = 0,
        val imgUrl: String = "",
        @OneToMany(mappedBy = "productId", cascade = [CascadeType.MERGE], orphanRemoval = true)
        val translations: MutableList<ProductTranslation> = arrayListOf())