package com.mda.diet.api

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.autoconfigure.domain.EntityScan
import org.springframework.data.jpa.repository.config.EnableJpaRepositories

@EntityScan(basePackages= ["com.mda.diet.model"])
@EnableJpaRepositories(basePackages= ["com.mda.diet.repository"])
@SpringBootApplication(scanBasePackages = ["com.mda.diet.controller", "com.mda.diet.security", "com.mda.diet.service"])
class ApiApplication

fun main(args: Array<String>) {
    SpringApplication.run(ApiApplication::class.java, *args)
}
