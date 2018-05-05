package com.mda.diet.api

import com.mda.diet.repository.ChatParticipantRepository
import org.springframework.boot.context.event.ApplicationReadyEvent
import org.springframework.context.ApplicationListener
import org.springframework.stereotype.Component

@Component
class ApplicationStartup(val chatParticipantRepository: ChatParticipantRepository)
    : ApplicationListener<ApplicationReadyEvent> {

    override fun onApplicationEvent(p0: ApplicationReadyEvent?) {
        //If the API shut down before the previous websockets are closed, the records are not deleted
        //So, delete every previous chatParticipants before running the API
        chatParticipantRepository.deleteAll()
    }
}