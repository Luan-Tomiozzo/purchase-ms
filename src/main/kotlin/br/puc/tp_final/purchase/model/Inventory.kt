package br.puc.tp_final.purchase.model

import javax.persistence.*

@Entity
@Table(name = "tb_inventory")
data class Inventory(

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "inventoryId")
    val inventoryId: Long? = null,

    @Column(name = "name")
    val name: String,

    @Column(name = "description")
    val description: String,

    @Column(name = "quantity")
    val quantity: Long,

    @Column(name = "maxQuantity")
    val maxQuantity: Long,

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "inventory", cascade = [CascadeType.ALL])
    val productsInventories: List<ProductInventory>? = null
)