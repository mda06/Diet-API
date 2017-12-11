package com.mda.diet.api

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
@SpringBootApplication(scanBasePackages = arrayOf("com.mda.diet.controller"))
class ApiApplication

fun main(args: Array<String>) {
    SpringApplication.run(ApiApplication::class.java, *args)
}
