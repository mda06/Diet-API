package com.mda.diet.repository

import com.mda.diet.model.Product
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.repository.PagingAndSortingRepository
import javax.transaction.Transactional

@Transactional
interface ProductRepository: PagingAndSortingRepository<Product, Long> {
    fun findByNameLike(name: String?, pageable: Pageable?): Page<Product>
}