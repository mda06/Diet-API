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
    fun getProductById(@PathVariable id: Long, lang: String?) = service.getProductById(id, lang)

    @GetMapping()
    fun getProducts(pageable: Pageable?, name: String?, lang: String?) = service.getProducts(pageable, name, lang)

    @PostMapping("/batch")
    fun addBatchProducts() = service.addBatchProducts()

    @DeleteMapping("/purge")
    fun deleteProducts() = service.deleteProducts()
}