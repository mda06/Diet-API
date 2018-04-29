package com.mda.diet.api

import com.mda.diet.controller.prefix
import org.springframework.context.annotation.Configuration
import org.springframework.web.socket.config.annotation.AbstractWebSocketMessageBrokerConfigurer
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker
import org.springframework.web.socket.config.annotation.StompEndpointRegistry
import org.springframework.messaging.simp.config.MessageBrokerRegistry
import org.springframework.http.HttpStatus
import org.springframework.web.servlet.ModelAndView
import org.springframework.boot.autoconfigure.web.ErrorViewResolver
import org.springframework.context.annotation.Bean


@Configuration
@EnableWebSocketMessageBroker
class WebSocketConfig : AbstractWebSocketMessageBrokerConfigurer() {

    //https://stackoverflow.com/questions/38516667/springboot-angular2-how-to-handle-html5-urls
    //Used to return to index.html if it's not a API call
    @Bean
    fun supportPathBasedLocationStrategyWithoutHashes(): ErrorViewResolver {
        return ErrorViewResolver { _, status, _ ->
            if (status == HttpStatus.NOT_FOUND)
                ModelAndView("index.html", HttpStatus.OK)
            else
                null
        }
    }

    override fun registerStompEndpoints(registry: StompEndpointRegistry) {
        registry.addEndpoint("$prefix/socket")
                .setAllowedOrigins("*")
                .withSockJS()
    }

    override fun configureMessageBroker(registry: MessageBrokerRegistry) {
        registry.setApplicationDestinationPrefixes(prefix)
                .enableSimpleBroker("/chat")
    }
}