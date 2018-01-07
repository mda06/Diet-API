package com.mda.diet.error

import org.springframework.http.HttpStatus
import java.util.*

data class ApiError(val status: HttpStatus? = null, val message: String? = null, val errors: List<String> = listOf()) {
    constructor(status: HttpStatus, message: String, error: String) :
        this(status, message, Arrays.asList(error))
}