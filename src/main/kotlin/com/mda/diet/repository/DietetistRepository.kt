package com.mda.diet.repository

import com.mda.diet.model.Dietetist
import org.springframework.data.repository.CrudRepository


interface DietetistRepository: CrudRepository<Dietetist, Long>