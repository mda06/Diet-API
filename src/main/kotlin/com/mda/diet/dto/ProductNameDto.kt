package com.mda.diet.dto

import com.mda.diet.model.Product

data class ProductNameDto(val id: Long, val name: String) {
    constructor(product: Product) : this(product.id, product.translations[0].name) {
        println("${product.translations.size}")
    }
}