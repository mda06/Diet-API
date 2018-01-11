package com.mda.diet.repository

import com.mda.diet.model.Product
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.PagingAndSortingRepository
import javax.transaction.Transactional

@Transactional
interface ProductRepository: PagingAndSortingRepository<Product, Long> {
    @Query(value = "SELECT DISTINCT p FROM Product p JOIN FETCH p.translations as pt " +
                    "WHERE pt.language = ?1 AND pt.name like ?2",
            countQuery = "SELECT count(DISTINCT p) FROM Product p JOIN p.translations as pt " +
                    "WHERE pt.language = ?1 AND pt.name like ?2")
    fun findByTranslationsLanguageEqualsAndTranslationsNameLike(language: String, name: String, pageable: Pageable): Page<Product>

}