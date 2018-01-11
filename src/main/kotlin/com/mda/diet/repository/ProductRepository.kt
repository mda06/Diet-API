package com.mda.diet.repository

import com.mda.diet.model.Product
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.PagingAndSortingRepository
import javax.transaction.Transactional

@Transactional
interface ProductRepository: PagingAndSortingRepository<Product, Long> {
    @Query("SELECT DISTINCT p FROM Product p JOIN FETCH p.translations as pt WHERE pt.language = ?1")
    fun findByTranslationsLanguageEquals(language: String): List<Product>

}