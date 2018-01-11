package com.mda.diet.dto

import com.mda.diet.model.Nutriment
import com.mda.diet.model.Product
import com.mda.diet.model.ProductTranslation

data class ProductDto (var id: Long = 0,
                    val name: String = "",
                    val imgUrl: String = "",
                    val units: List<Nutriment> = arrayListOf(),
                    val macros: List<Nutriment> = arrayListOf(),
                    val micros: List<Nutriment> = arrayListOf()) {
    fun toProduct(language: String): Product {
        val prod = Product(id, imgUrl, arrayListOf(ProductTranslation(0, language, name, id,
                units.toMutableList(), macros.toMutableList(), micros.toMutableList())))
        prod.translations[0].units.forEach{ it.productTranslation = prod.translations[0]}
        prod.translations[0].macros.forEach{ it.productTranslation = prod.translations[0]}
        prod.translations[0].micros.forEach{ it.productTranslation = prod.translations[0]}
       return prod
    }
}