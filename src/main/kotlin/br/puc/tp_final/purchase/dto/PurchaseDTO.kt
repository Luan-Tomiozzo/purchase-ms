package br.puc.tp_final.purchase.dto

import com.fasterxml.jackson.annotation.JsonProperty
import io.swagger.v3.oas.annotations.media.Schema
import javax.validation.constraints.NotEmpty
import javax.validation.constraints.NotNull
import javax.validation.constraints.Positive

data class PurchaseDTO(

    @Schema(description = "Lista de produtos a serem comprados.", type = "List")
    @NotEmpty(message = "A lista de produtos não pode ser vazia.")
    @JsonProperty("products")
    val products: List<@NotNull(message = "Informe um produto para a lista. Não pode ser composta de elementos nulos.") ProductDTO>,

    @Schema(description = "Id do tipo de pagamento.", example = "1")
    @NotNull(message = "O id do type de pagamento não pode ser nulo.")
    @Positive(message = "O id do tipo de pagamento não pode ser negativo.")
    @JsonProperty("paymentTypeId")
    val paymentTypeId: Long,

    @Schema(description = "Id do registro da entrega.", example = "1")
    @NotNull(message = "O id do registro de entrega não pode ser nulo.")
    @Positive(message = "O id do registro de entrega não pode ser negativo.")
    @JsonProperty("deliverId")
    val deliverId: Long
)