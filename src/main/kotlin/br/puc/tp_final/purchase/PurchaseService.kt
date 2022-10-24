package br.puc.tp_final.purchase

import br.puc.tp_final.purchase.event.EventProducer
import org.springframework.stereotype.Service

@Service
class PurchaseService(val eventProducer:  EventProducer) {

    fun buy(): Int {
        return eventProducer.sendNewPurchaseDetails()
    }
}