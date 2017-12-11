package com.mda.diet.repository

import com.mda.diet.model.Admin
import org.springframework.data.repository.CrudRepository


interface AdminRepository: CrudRepository<Admin, Long>