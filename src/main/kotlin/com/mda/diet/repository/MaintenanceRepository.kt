package com.mda.diet.repository

import com.mda.diet.model.Maintenance
import org.springframework.data.repository.CrudRepository


interface MaintenanceRepository : CrudRepository<Maintenance, Long> {
    fun findFirstByOrderById(): Maintenance?
}