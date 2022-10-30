package br.puc.tp_final.purchase.model

import javax.persistence.*

@Entity
@Table(name = "tb_purchase")
data class Purchase (

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "purchaseId")
    val purchaseId: Long? = null,

    @Column(name = "value")
    val value: Double,

    @ManyToOne(optional = true, fetch = FetchType.LAZY)
    @JoinColumn(name = "paymentType", referencedColumnName = "paymentTypeId", foreignKey = ForeignKey(name = "fk_purchase_payment"))
    val paymentType: PaymentType,

    @ManyToOne(optional = true, fetch = FetchType.LAZY)
    @JoinColumn(name = "deliver", referencedColumnName = "deliverId", foreignKey = ForeignKey(name = "fk_purchase_deliver"))
    val deliver: Deliver,

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "purchase", cascade = [CascadeType.ALL])
    val products: List<ProductPurchase>? = null
)