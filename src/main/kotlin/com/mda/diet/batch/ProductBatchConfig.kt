package com.mda.diet.batch

import com.mda.diet.model.Product
import com.mda.diet.repository.ProductRepository
import org.springframework.batch.core.Job
import org.springframework.batch.core.Step
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory
import org.springframework.batch.core.launch.support.RunIdIncrementer
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class ProductBatchConfig(val jobBuilderFactory: JobBuilderFactory,
                         val stepBuilderFactory: StepBuilderFactory,
                         val repository: ProductRepository) {
    @Bean
    fun job(): Job {
        return jobBuilderFactory.get("job")
                .incrementer(RunIdIncrementer())
                .flow(step1())
                .end()
                .build()
    }

    @Bean
    fun step1(): Step {
        return stepBuilderFactory.get("step1")
                .chunk<Product, Product>(100)
                .reader(ProductReader())
                //.processor(Processor())
                .writer(ProductWriter(repository))
                .build()
    }
}