package br.puc.tp_final.purchase.event

import br.puc.tp_final.purchase.model.Deliver
import br.puc.tp_final.purchase.model.Purchase
import br.puc.tp_final.purchase.model.User
import br.puc.tp_final.purchase.service.ProductInventoryService
import mu.KotlinLogging
import org.springframework.amqp.rabbit.core.RabbitTemplate
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Qualifier
import org.springframework.stereotype.Service
import java.util.*
import kotlin.collections.HashMap

const val ROUTING_KEY_EXCHANGE = "events.business.purchase";
const val NEW_USER_ROUTING_KEY = "purchase.user.created"
const val NEW_DELIVER_ROUTING_KEY = "purchase.deliver.created"

@Service
class EventProducer(@Qualifier("rabbitTemplateProducer") private val rabbitTemplate: RabbitTemplate) {
    val logger = KotlinLogging.logger { }

    @Autowired
    lateinit var service: ProductInventoryService;

    fun sendNewUserDetails(): Int {
        logger.info("sending user details")

        val user = User(
            userId = UUID.randomUUID().hashCode(),
            userName = "John Doe",
            deliver = Deliver(
                deliverId = UUID.randomUUID().hashCode(),
                aptNo = 75,
                streetName = " St Alphonsus St",
                city = "Jammu",
                isHomeAddress = true
            ),
            email = "https://goo.gl/4Db4NK"
        )
        rabbitTemplate.convertAndSend(ROUTING_KEY_EXCHANGE, NEW_USER_ROUTING_KEY, user)

        return user.userId
    }

    fun sendNewPurchaseDetails(purchase: Purchase): Int {
        logger.info("sending purchase details")

        if (service.verifyQuantityProductInventory(purchase.products)) {
            rabbitTemplate.convertAndSend(ROUTING_KEY_EXCHANGE, NEW_DELIVER_ROUTING_KEY, purchase)
        }

        return purchase.purchaseId
    }
}