package br.puc.tp_final.purchase.model

import com.fasterxml.jackson.annotation.JsonProperty

data class Payment(

    @JsonProperty("paymentId") val paymentId: Long
)