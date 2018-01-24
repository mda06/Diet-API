package com.mda.diet.controller

import com.mda.diet.dto.DietFavProduct
import com.mda.diet.service.ProductService
import org.springframework.web.bind.annotation.*
import org.springframework.data.domain.Pageable
import org.springframework.web.multipart.MultipartFile

@RestController
@RequestMapping("$prefix/product")
class ProductController(val service: ProductService) {

    @GetMapping("/size")
    fun getSizeOfProducts() = service.getSize()

    @GetMapping("/{id}")
    fun getProductById(@PathVariable id: Long, lang: String?, diet: Long?) = service.getProductById(id, lang, diet)

    @GetMapping()
    fun getProducts(pageable: Pageable?, name: String?, lang: String?, diet: Long?) = service.getProducts(pageable, name, lang, diet)

    @PostMapping("/fav/add")
    fun addProdToFav(@RequestBody fav: DietFavProduct) = service.addProdToFav(fav)

    @PostMapping("/fav/remove")
    fun removeProdFromFav(@RequestBody fav: DietFavProduct) = service.removeProdFromFav(fav)

    @PostMapping("/batch")
    fun addBatchProducts() = service.addBatchProducts()

    @PostMapping("/batch/upload")
    fun uploadBatch(@RequestParam("file") uploadFile: MultipartFile) = service.uploadBatch(uploadFile)

    @DeleteMapping("/purge")
    fun deleteProducts() = service.deleteProducts()

    @DeleteMapping("/{id}")
    fun deleteProduct(@PathVariable id: Long) = service.deleteProduct(id)
}