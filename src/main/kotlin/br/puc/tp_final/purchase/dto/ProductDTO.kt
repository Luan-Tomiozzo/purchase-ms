package br.puc.tp_final.purchase.dto

import com.fasterxml.jackson.annotation.JsonProperty
import io.swagger.v3.oas.annotations.media.Schema
import javax.validation.constraints.NotNull
import javax.validation.constraints.Positive

data class ProductDTO (

    @Schema(description = "Id do produto.", example = "1")
    @NotNull(message = "O id do produto não pode ser nulo.")
    @Positive(message = "O id do produto não pode ser negativo.")
    @JsonProperty("productId")
    val productId: Long,

    @Schema(description = "Quantidade do produto.", example = "5")
    @NotNull(message = "A quantidade do produto não pode ser nula.")
    @Positive(message = "A quantidade do produto não pode ser negativa.")
    @JsonProperty("quantity")
    val quantity: Long
)