package com.example.bookEcommerce.model

import jakarta.persistence.*


@Entity
@Table(name = "cart_item")
data class CartItem(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = 0,
    @Column(name = "total_price")
    var unitPrice: Float = 0.0f,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "book_id", referencedColumnName = "id")
    var book: Book? = null,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cart_id", referencedColumnName = "id")
    var cart: Cart? = null
)