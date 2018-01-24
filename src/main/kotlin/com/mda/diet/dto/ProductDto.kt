package com.mda.diet.dto

import com.mda.diet.model.Nutriment
import com.mda.diet.model.Product
import com.mda.diet.model.ProductTranslation

data class ProductDto ( var id: Long = 0,
                        val imgUrl: String = "",
                        val name: String = "",
                        val units: List<Nutriment> = arrayListOf(),
                        val macros: List<Nutriment> = arrayListOf(),
                        val micros: List<Nutriment> = arrayListOf()) {

    constructor(prod: Product) : this(prod.id, prod.imgUrl,
            prod.translations[0].name,
            prod.translations[0].units,
            prod.translations[0].macros,
            prod.translations[0].micros)

    fun toProduct(language: String): Product {
        val prod = Product(id, imgUrl, arrayListOf(ProductTranslation(0, language, name, id,
                units.toMutableList(), macros.toMutableList(), micros.toMutableList())))
       return prod
    }
}