package br.puc.tp_final.purchase.model

import javax.persistence.*

@Entity
@Table(name = "tb_payment_type")
data class PaymentType (

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "paymentTypeId")
    val paymentTypeId: Long? = null,

    @Column(name = "type")
    val type: String,

    @Column(name = "description")
    val description: String,

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "paymentType", cascade = [CascadeType.ALL])
    val purchases: List<Purchase>? = null
)