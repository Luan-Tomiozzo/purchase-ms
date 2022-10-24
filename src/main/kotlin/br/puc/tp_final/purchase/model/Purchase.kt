package br.puc.tp_final.purchase.model

import com.fasterxml.jackson.annotation.JsonProperty

data class Purchase(

    @JsonProperty("purchaseId") val purchaseId: Int,
    @JsonProperty("purchaseName") val purchaseName: String,
    @JsonProperty("product") val product: List<Product>,
    @JsonProperty("totalQuantity") val totalQuantity: Int,
    @JsonProperty("isSameDayDelivery") val isSameDayDelivery: Boolean
)