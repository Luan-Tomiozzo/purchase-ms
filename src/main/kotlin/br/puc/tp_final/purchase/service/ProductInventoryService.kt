package br.puc.tp_final.purchase.service

import br.puc.tp_final.purchase.exception.BusinessException
import br.puc.tp_final.purchase.repositories.ProductInventoryRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class ProductInventoryService {

    @Autowired
    lateinit var repository: ProductInventoryRepository;

    fun verifyQuantityProductInventory(products: Map<Long, Long>): Boolean {
        products.forEach{(id, quantity) ->
            run {
                val pi = repository.findByProduct(id).orElseThrow { BusinessException("Produto não localizado") };

                if (pi.quantity < quantity) {
                    throw BusinessException("O estoque não possui a quantidade solicitada para o produto " + id + ".");
                } else {
                    pi.quantity = pi.quantity - quantity;
                    repository.save(pi);
                }
            }
        }
        return true;
    }

}