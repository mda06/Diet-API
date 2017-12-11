package com.mda.diet.api

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.autoconfigure.domain.EntityScan
import org.springframework.data.jpa.repository.config.EnableJpaRepositories

@EntityScan(basePackages=arrayOf("com.mda.diet.model"))
@EnableJpaRepositories(basePackages=arrayOf("com.mda.diet.repository"))
@SpringBootApplication(scanBasePackages = arrayOf("com.mda.diet.controller"))
class ApiApplication

fun main(args: Array<String>) {
    SpringApplication.run(ApiApplication::class.java, *args)
}
