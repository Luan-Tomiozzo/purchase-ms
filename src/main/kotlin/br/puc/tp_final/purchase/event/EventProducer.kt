package br.puc.tp_final.purchase.event

import br.puc.tp_final.purchase.model.Deliver
import br.puc.tp_final.purchase.model.Product
import br.puc.tp_final.purchase.model.Purchase
import br.puc.tp_final.purchase.model.User
import mu.KotlinLogging
import org.springframework.amqp.rabbit.core.RabbitTemplate
import org.springframework.beans.factory.annotation.Qualifier
import org.springframework.stereotype.Service
import java.util.*

const val NEW_USER_ROUTING_KEY = "purchase.user.created"
const val NEW_DELIVER_ROUTING_KEY = "purchase.deliver.created"

@Service
class EventProducer(@Qualifier("rabbitTemplateProducer") private val rabbitTemplate: RabbitTemplate) {
    val logger = KotlinLogging.logger { }

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
        rabbitTemplate.convertAndSend(NEW_USER_ROUTING_KEY, user)

        return user.userId
    }

    fun sendNewPurchaseDetails(): Int {
        logger.info("sending purchase details")

        val purchase = Purchase(
            purchaseId = UUID.randomUUID().hashCode(),
            purchaseName = "Flowers",
            isSameDayDelivery = true,
            product = listOf(
                Product(productId = UUID.randomUUID().hashCode(), name = "Roses", quantity = 25),
                Product(productId = UUID.randomUUID().hashCode(), name = "Plumeria", quantity = 20)
            ),
            totalQuantity = 45
        )
        rabbitTemplate.convertAndSend(NEW_DELIVER_ROUTING_KEY, purchase)

        return purchase.purchaseId
    }
}