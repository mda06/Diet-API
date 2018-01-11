package com.mda.diet.repository

import com.mda.diet.model.Product
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.PagingAndSortingRepository
import javax.transaction.Transactional

@Transactional
interface ProductRepository: PagingAndSortingRepository<Product, Long> {
    //"SELECT DISTINCT p FROM Product p JOIN FETCH p.translations as pt WHERE pt.language = ?1"
    @Query(value = "SELECT DISTINCT p FROM Product p JOIN FETCH p.translations as pt WHERE pt.language = ?1",
            countQuery = "SELECT count(DISTINCT p) FROM Product p JOIN p.translations as pt WHERE pt.language = ?1")
    fun findByTranslationsLanguageEquals(language: String, pageable: Pageable): Page<Product>

}