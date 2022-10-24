package br.puc.tp_final.purchase.model

import com.fasterxml.jackson.annotation.JsonProperty

data class Product(

    @JsonProperty("productId") val productId: Int,
    @JsonProperty("name") val name: String,
    @JsonProperty("quantity") val quantity: Int
)