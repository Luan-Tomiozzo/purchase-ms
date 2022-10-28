package br.puc.tp_final

import br.puc.tp_final.purchase.domain.Inventory
import br.puc.tp_final.purchase.domain.Product
import br.puc.tp_final.purchase.domain.ProductInventory
import br.puc.tp_final.purchase.repositories.InventoryRepository
import br.puc.tp_final.purchase.repositories.ProductInventoryRepository
import br.puc.tp_final.purchase.repositories.ProductRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.CommandLineRunner
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.Bean
import org.springframework.scheduling.annotation.EnableScheduling

@EnableScheduling
@SpringBootApplication
class ApplicationBoot {

    @Autowired
    lateinit var productRepository: ProductRepository;

    @Autowired
    lateinit var inventoryRepository: InventoryRepository;

    @Autowired
    lateinit var productInventoryRepository: ProductInventoryRepository;

    @Bean
    fun init() = CommandLineRunner {
        var product: Product = Product(1, "Chocolate");
        var inventory: Inventory = Inventory(1, "Estoque 1", 20);
        var productInventory: ProductInventory = ProductInventory(1, product, inventory, 10);
        productRepository.save(product);
        inventoryRepository.save(inventory);
        productInventoryRepository.save(productInventory);
    }

}

fun main(args: Array<String>) {
    runApplication<ApplicationBoot>(*args)
}