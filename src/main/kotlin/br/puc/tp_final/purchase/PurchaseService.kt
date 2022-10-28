package br.puc.tp_final.purchase

import br.puc.tp_final.purchase.event.EventProducer
import br.puc.tp_final.purchase.model.Purchase
import org.springframework.stereotype.Service

@Service
class PurchaseService(val eventProducer:  EventProducer) {

    fun buy(purchase: Purchase): Int {
        return eventProducer.sendNewPurchaseDetails(purchase)
    }
}