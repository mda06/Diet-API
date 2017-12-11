package com.mda.diet.repository

import com.mda.diet.model.Address
import org.springframework.data.repository.CrudRepository

interface AddressRepository : CrudRepository<Address, Long>