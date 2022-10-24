package br.puc.tp_final.purchase

import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/purchase-ms/rest/purchase")
class PurchaseController(val purchaseService: PurchaseService) {

    @PostMapping("buy")
    fun buy(): Int {
        return purchaseService.buy()
    }
}