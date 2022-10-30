package br.puc.tp_final.purchase

import br.puc.tp_final.purchase.dto.PurchaseDTO
import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.media.Content
import io.swagger.v3.oas.annotations.media.Schema
import io.swagger.v3.oas.annotations.responses.ApiResponse
import io.swagger.v3.oas.annotations.tags.Tag
import org.springframework.web.bind.annotation.*
import javax.validation.Valid

@RestController
@RequestMapping("/purchase-ms/rest/purchase")
@Tag(name = "Endpoints para realização de compras")
class PurchaseController(val purchaseService: PurchaseService) {

    @PostMapping("/buy")
    @ApiResponse(responseCode = "200", description = "OK", content = [Content(mediaType = "application/json", schema = Schema(implementation = PurchaseDTO::class))])
    @Operation(summary = "Envia requisição de compra", description = "Envia requisição de compra.")
    fun buy(@RequestBody @Valid purchase: PurchaseDTO): Int {
        return purchaseService.buy(purchase)
    }
}