package br.puc.tp_final.purchase.domain

import javax.persistence.*

@Entity
@Table(name = "tb_product_inventory")
data class ProductInventory(

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        val id: Long,

        @ManyToOne(optional = true, fetch = FetchType.LAZY)
        @JoinColumn(name = "product_id", referencedColumnName = "id")
        val product: Product,

        @ManyToOne(optional = true, fetch = FetchType.LAZY)
        @JoinColumn(name = "inventory_id", referencedColumnName = "id")
        val inventory: Inventory,

        @Column(name = "quantity")
        var quantity: Long

)