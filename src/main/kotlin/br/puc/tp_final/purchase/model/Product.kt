package br.puc.tp_final.purchase.model

import javax.persistence.*

@Entity
@Table(name = "tb_product")
data class Product(

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "productId")
    val productId: Long? = null,

    @Column(name = "name")
    val name: String,

    @Column(name = "description")
    val description: String,

    @Column(name = "value")
    val value: Double,

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "product", cascade = [CascadeType.ALL])
    val productsPurchases: List<ProductPurchase>? = null,

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "product", cascade = [CascadeType.ALL])
    val productsInventories: List<ProductInventory>? = null
)