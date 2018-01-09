package com.mda.diet.repository

import com.mda.diet.model.Product
import org.springframework.data.repository.PagingAndSortingRepository
import javax.transaction.Transactional

@Transactional
interface ProductRepository: PagingAndSortingRepository<Product, Long> {
}