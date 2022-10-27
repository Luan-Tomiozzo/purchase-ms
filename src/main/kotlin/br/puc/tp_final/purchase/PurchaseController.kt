package br.puc.tp_final.purchase

import org.springframework.web.bind.annotation.*

import io.swagger.annotations.ApiOperation
import io.swagger.annotations.ApiResponse
import br.puc.tp_final.purchase.model.Purchase

@RestController
@RequestMapping("/purchase-ms/rest/purchase")
class PurchaseController(val purchaseService: PurchaseService) {

    @PostMapping("buy")
    @ApiOperation(value = "Envia requisição de compra", response = Purchase::class)
    fun buy(@RequestBody purchase: Purchase): Int {
        return purchaseService.buy()
    }
}