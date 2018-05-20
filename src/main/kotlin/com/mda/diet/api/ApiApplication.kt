package com.mda.diet.api

import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing
import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.autoconfigure.domain.EntityScan
import org.springframework.context.annotation.Bean
import org.springframework.data.jpa.repository.config.EnableJpaRepositories
import org.springframework.scheduling.annotation.EnableAsync
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor
import java.util.concurrent.Executor


@EntityScan(basePackages= ["com.mda.diet.model"])
@EnableJpaRepositories(basePackages= ["com.mda.diet.repository"])
@SpringBootApplication(scanBasePackages = ["com.mda.diet.controller", "com.mda.diet.security",
    "com.mda.diet.service", "com.mda.diet.error", "com.mda.diet.batch", "com.mda.diet.websocket",
    "com.mda.diet.api"])
@EnableBatchProcessing
@EnableAsync
class ApiApplication {
    @Bean
    fun asyncExecutor(): Executor {
        val executor = ThreadPoolTaskExecutor()
        executor.corePoolSize = 2
        executor.maxPoolSize = 2
        executor.setQueueCapacity(500)
        executor.threadNamePrefix = "Products"
        executor.initialize()
        return executor
    }
}

fun main(args: Array<String>) {
    val environment = "development"
    System.setProperty("spring.config.name", environment)
    System.setProperty("spring.profiles.active", environment)
    println("Started API in $environment")
    SpringApplication.run(ApiApplication::class.java, *args)
}
