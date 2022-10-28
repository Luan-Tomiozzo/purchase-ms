package br.puc.tp_final.purchase.model

import com.fasterxml.jackson.annotation.JsonProperty

data class Purchase(

        @JsonProperty("purchaseId") val purchaseId: Int,
        @JsonProperty("product") val products: Map<Long, Long>,
        @JsonProperty("isSameDayDelivery") val isSameDayDelivery: Boolean
)