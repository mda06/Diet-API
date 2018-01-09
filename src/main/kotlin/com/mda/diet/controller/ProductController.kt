package com.mda.diet.controller

import com.mda.diet.service.ProductService
import org.springframework.web.bind.annotation.*
import org.springframework.data.domain.Pageable

@RestController
@RequestMapping("$prefix/product")
class ProductController(val service: ProductService) {

    @GetMapping("/size")
    fun getSizeOfProducts() = service.getSize()

    @GetMapping()
    fun getProducts(pageable: Pageable) = service.getProducts(pageable)

    @PostMapping("/batch")
    fun addBatchProducts() = service.addBatchProducts()

    @PostMapping("/test")
    fun addTestProduct() = service.addTestProduct()

    @DeleteMapping
    fun deleteProducts() = service.deleteProducts()
}