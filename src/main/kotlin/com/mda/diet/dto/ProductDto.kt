package com.mda.diet.dto

import com.mda.diet.model.Nutriment
import com.mda.diet.model.Product
import com.mda.diet.model.ProductTranslation

data class ProductDto ( var id: Long = 0,
                        val imgUrl: String = "",
                        val name: String = "",
                        val units: List<Nutriment> = arrayListOf(),
                        val macros: List<Nutriment> = arrayListOf(),
                        val micros: List<Nutriment> = arrayListOf(),
                        val favorite: Boolean = false) {

    constructor(prod: Product, favorite: Boolean) : this(prod.id, prod.imgUrl,
            if(prod.translations.size > 0) prod.translations[0].name else "",
            if(prod.translations.size > 0) prod.translations[0].units else arrayListOf(),
            if(prod.translations.size > 0) prod.translations[0].macros else arrayListOf(),
            if(prod.translations.size > 0) prod.translations[0].micros else arrayListOf(),
            favorite)

    fun toProduct(language: String): Product {
        val prod = Product(id, imgUrl, arrayListOf(ProductTranslation(0, language, name, id,
                units.toMutableList(), macros.toMutableList(), micros.toMutableList())))
       return prod
    }
}