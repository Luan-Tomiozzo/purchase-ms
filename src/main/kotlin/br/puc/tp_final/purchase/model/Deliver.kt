package br.puc.tp_final.purchase.model

import com.fasterxml.jackson.annotation.JsonProperty

data class Deliver(

    @JsonProperty("deliverId") val deliverId: Int,
    @JsonProperty("aptNo") val aptNo: Int,
    @JsonProperty("streetName") val streetName: String,
    @JsonProperty("city") val city: String,
    @JsonProperty("isHomeAddress") val isHomeAddress: Boolean
)