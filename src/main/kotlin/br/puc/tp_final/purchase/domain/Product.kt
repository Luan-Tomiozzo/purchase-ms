package br.puc.tp_final.purchase.domain

import com.fasterxml.jackson.annotation.JsonProperty
import javax.persistence.*

@Entity
@Table(name = "tb_product")
data class Product(

    @JsonProperty("productId")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    val productId: Long,

    @JsonProperty("name")
    @Column(name = "name")
    val description: String

)