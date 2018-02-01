package com.mda.diet.repository

import com.mda.diet.model.Menu
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.CrudRepository


interface MenuRepository: CrudRepository<Menu, Long> {
    fun findByPatientId(id: Long): List<Menu>
    @Query("SELECT  m FROM Menu m WHERE MONTH(m.date) = ?1 AND YEAR(m.date) = ?2 AND m.patient.id = ?3")
    fun findByDate(month: Int, year: Int, patientId: Long): List<Menu>
}