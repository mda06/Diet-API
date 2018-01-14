package com.mda.diet.repository

import com.mda.diet.dto.ProductNameDto
import com.mda.diet.model.ProductTranslation
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.PagingAndSortingRepository

interface ProductTranslationRepository: PagingAndSortingRepository<ProductTranslation, Long> {
    @Query(value = "SELECT NEW com.mda.diet.dto.ProductNameDto(pt.productId, pt.name) FROM ProductTranslation pt " +
            "WHERE pt.language = ?1 AND pt.name like ?2",
            countQuery = "SELECT count(*) FROM ProductTranslation pt " +
                    "WHERE pt.language = ?1 AND pt.name like ?2")
    fun findByLanguageAndNameLike(language: String, name: String, pageable: Pageable?): Page<ProductNameDto>
}