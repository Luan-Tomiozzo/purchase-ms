package br.puc.tp_final.purchase.event

import br.puc.tp_final.purchase.dto.PurchaseDTO
import br.puc.tp_final.purchase.repositories.ProductRepository
import br.puc.tp_final.purchase.service.ProductInventoryService
import mu.KotlinLogging
import org.springframework.amqp.rabbit.core.RabbitTemplate
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Qualifier
import org.springframework.stereotype.Service

const val ROUTING_EXCHANGE_KEY = "purchase.exchange";
const val PURCHASE_ROUTING_KEY = "purchase.queue"

@Service
class EventProducer(@Qualifier("rabbitTemplateProducer") private val rabbitTemplate: RabbitTemplate) {

    val logger = KotlinLogging.logger { }

    @Autowired
    lateinit var productRepository: ProductRepository

    @Autowired
    lateinit var productInventoryService: ProductInventoryService;

    fun makePurchase(purchaseDTO: PurchaseDTO): Boolean {
        logger.info("Efetuando rotina de compra...")

        if (productInventoryService.verifyQuantityProductInventory(purchaseDTO.products)) {
            rabbitTemplate.convertAndSend(ROUTING_EXCHANGE_KEY, PURCHASE_ROUTING_KEY, purchaseDTO)
        }

        return true
    }
}