package com.example.bookEcommerce.model

import jakarta.persistence.*


@Entity
@Table(name = "invoice_item")
data class InvoiceItem(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long = 0,
    @Column(name = "unit_price")
    var unitPrice: Float = 0.0f,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "invoice_id", referencedColumnName = "id")
    var invoice: Invoice? = null,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "book_id", referencedColumnName = "id")
    var book: Book? = null,
    )