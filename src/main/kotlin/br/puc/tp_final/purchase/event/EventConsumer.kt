package br.puc.tp_final.purchase.event

import br.puc.tp_final.purchase.dto.PurchaseDTO
import br.puc.tp_final.purchase.exception.BusinessException
import br.puc.tp_final.purchase.model.*
import br.puc.tp_final.purchase.repositories.*
import mu.KotlinLogging
import org.springframework.amqp.rabbit.annotation.RabbitListener
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import javax.transaction.Transactional

const val PURCHASE_QUEUE = "purchaseQueue"

@Service
class EventConsumer {

    private val logger = KotlinLogging.logger { }

    @Autowired
    lateinit var productRepository: ProductRepository

    @Autowired
    lateinit var paymentTypeRepository: PaymentTypeRepository

    @Autowired
    lateinit var deliverRepository: DeliverRepository

    @Autowired
    lateinit var purchaseRepository: PurchaseRepository

    @Autowired
    lateinit var productPurchaseRepository: ProductPurchaseRepository

    @RabbitListener(queues = [PURCHASE_QUEUE])
    @Transactional
    fun receiveNewPurchase(purchaseDTO: PurchaseDTO) {
        logger.info("Compra {} recebida", purchaseDTO)

        val paymentType: PaymentType = paymentTypeRepository.findById(purchaseDTO.paymentTypeId).orElseThrow{ BusinessException("Tipo de pagamento não encontrado.") }
        val deliver: Deliver = deliverRepository.findById(purchaseDTO.deliverId).orElseThrow{ BusinessException("Informações de entrega não encontradas.") }
        purchaseDTO.products.forEach { (productId, quantity) ->
            run {
                val product: Product = productRepository.findById(productId).orElseThrow{ BusinessException("Produto não localizado.") }
                val purchase: Purchase = Purchase(value = quantity * product.value, paymentType = paymentType, deliver = deliver)
                val productPurchase: ProductPurchase = ProductPurchase(product = product, purchase = purchase, productQuantity = quantity)
                productPurchaseRepository.save(productPurchase)
            }
        }
    }
}