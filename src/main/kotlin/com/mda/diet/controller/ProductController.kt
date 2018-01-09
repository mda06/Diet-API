package com.mda.diet.controller

import com.mda.diet.service.ProductService
import org.springframework.web.bind.annotation.*
import org.springframework.data.domain.Pageable

@RestController
@RequestMapping("$prefix/product")
class ProductController(val service: ProductService) {

    @GetMapping("/size")
    fun getSizeOfProducts() = service.getSize()

    @GetMapping("/{id}")
    fun getProductById(@PathVariable id: Long) = service.getProductById(id)

    @GetMapping()
    fun getProducts(pageable: Pageable, name: String?) = service.getProducts(pageable, name)

    @PostMapping("/batch")
    fun addBatchProducts() = service.addBatchProducts()

    @DeleteMapping
    fun deleteProducts() = service.deleteProducts()
}