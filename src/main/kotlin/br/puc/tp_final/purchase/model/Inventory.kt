package br.puc.tp_final.purchase.model

import com.fasterxml.jackson.annotation.JsonProperty

data class Inventory(

    @JsonProperty("inventoryId") val inventoryId: Int
)