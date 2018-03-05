package com.mda.diet.repository

import com.mda.diet.model.LoginAccess
import org.springframework.data.repository.CrudRepository

interface LoginAccessRepository: CrudRepository<LoginAccess, String>