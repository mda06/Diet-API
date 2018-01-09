package com.mda.diet.dto

import com.mda.diet.model.Product

data class ProductDto(val id: Long, val name: String) {
    constructor(product: Product) : this(product.id, product.name)
}