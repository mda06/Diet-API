package com.mda.diet.controller

import com.mda.diet.dto.MaintenanceDto
import com.mda.diet.service.LoginAccessService
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*


@RestController
@RequestMapping("$prefix/maintenance")
class MaintenanceController(val service: LoginAccessService) {

    @PostMapping("/enable")
    fun putInMaintenance(@RequestBody maintenance: MaintenanceDto) = service.putInMaintenance(maintenance)

    @DeleteMapping("/disable")
    fun removeMaintenance() = service.removeMaintenance()

}