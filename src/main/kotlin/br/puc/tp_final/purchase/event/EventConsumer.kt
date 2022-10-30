package br.puc.tp_final.purchase.event

import br.puc.tp_final.purchase.dto.PurchaseDTO
import mu.KotlinLogging
import org.springframework.amqp.rabbit.annotation.RabbitListener
import org.springframework.stereotype.Service

const val DELIVER_DISPATCH_QUEUE = "deliverDispatchDepartment"
const val STORE_QUEUE = "allEvents"

@Service
class EventConsumer {
    private val logger = KotlinLogging.logger { }

    @RabbitListener(queues = [DELIVER_DISPATCH_QUEUE])
    fun receiveNewPurchase(message: PurchaseDTO) {
        logger.info(
            "Received Purchase " +
                    "{}", message
        )
    }

    @RabbitListener(queues = [STORE_QUEUE])
    fun allStoreEvents(message: Any) {
        logger.info(
            "Receiving all events " +
                    "{}", message
        )
    }
}