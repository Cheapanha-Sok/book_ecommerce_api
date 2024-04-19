package com.example.bookEcommerce.model

import jakarta.persistence.*


@Entity
@Table(name = "invoices")
data class Invoice(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = 0,
    @Column(name = "totalPrice")
    var totalPrice: Double = 0.00,
    @Column(name = "totalBook")
    var totalBook: Int = 0,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    var user: User? = null,

    @OneToMany(fetch = FetchType.LAZY , mappedBy = "invoice", cascade = [CascadeType.ALL])
    var invoiceItems: List<InvoiceItem>? = null
)