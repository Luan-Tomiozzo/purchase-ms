package br.puc.tp_final.purchase.model

import javax.persistence.*

@Entity
@Table(name = "tb_deliver")
data class Deliver(

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "deliverId")
    val deliverId: Int? = null,

    @Column(name = "addressNumber")
    val addressNumber: Int,

    @Column(name = "addressComplement")
    val addressComplement: String,

    @Column(name = "streetName")
    val streetName: String,

    @Column(name = "city")
    val city: String,

    @Column(name = "isHomeAddress")
    val isHomeAddress: Boolean,

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "deliver", cascade = [CascadeType.ALL])
    val purchases: List<Purchase>? = null
)