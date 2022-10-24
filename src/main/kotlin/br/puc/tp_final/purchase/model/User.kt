package br.puc.tp_final.purchase.model

import com.fasterxml.jackson.annotation.JsonProperty

data class User(

    @JsonProperty("userId") val userId: Int,
    @JsonProperty("userName") val userName: String,
    @JsonProperty("deliver") val deliver: Deliver,
    @JsonProperty("email") val email: String
)