package br.puc.tp_final.purchase

import br.puc.tp_final.purchase.event.EventProducer
import org.springframework.stereotype.Service

@Service
class UserService(val eventProducer: EventProducer) {

    fun register(): Int {
        return eventProducer.sendNewUserDetails()
    }
}