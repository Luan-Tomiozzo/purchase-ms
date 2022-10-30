package br.puc.tp_final.purchase.event

import br.puc.tp_final.purchase.dto.PurchaseDTO
import br.puc.tp_final.purchase.service.ProductInventoryService
import mu.KotlinLogging
import org.springframework.amqp.rabbit.core.RabbitTemplate
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Qualifier
import org.springframework.stereotype.Service

const val ROUTING_KEY_EXCHANGE = "events.business.purchase";
const val NEW_DELIVER_ROUTING_KEY = "purchase.deliver.created"

@Service
class EventProducer(@Qualifier("rabbitTemplateProducer") private val rabbitTemplate: RabbitTemplate) {
    val logger = KotlinLogging.logger { }

    @Autowired
    lateinit var productInventoryService: ProductInventoryService;

    fun sendNewPurchaseDetails(purchaseDTO: PurchaseDTO): Int {
        logger.info("Enviando detalhes da venda...")

        /*if (productInventoryService.verifyQuantityProductInventory(purchaseDTO.products)) {
            rabbitTemplate.convertAndSend(ROUTING_KEY_EXCHANGE, NEW_DELIVER_ROUTING_KEY, purchaseDTO)
        }*/

        return 1
    }
}