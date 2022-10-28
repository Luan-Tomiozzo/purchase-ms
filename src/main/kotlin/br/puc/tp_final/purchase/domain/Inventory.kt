package br.puc.tp_final.purchase.domain

import com.fasterxml.jackson.annotation.JsonProperty
import javax.persistence.*

@Entity
@Table(name = "tb_inventory")
data class Inventory(

        @JsonProperty("inventoryId")
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name = "id")
        val inventoryId: Long,

        @Column(name = "description")
        val description: String,

        @Column(name = "quantityMax")
        val quantityMax: Long
)