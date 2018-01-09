package com.mda.diet.repository

import com.mda.diet.model.Product
import org.springframework.data.repository.CrudRepository

interface ProductRepository: CrudRepository<Product, Long>