package com.example.bookEcommerce.model

import jakarta.persistence.*

@Entity
@Table(name = "carts")
data class Cart(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id :Long ? =null,
    @Column(name = "total_price")
    var totalPrice :Double? =0.00,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id" , referencedColumnName = "id")
    var user : User ?=null,

    @OneToMany(mappedBy = "cart" , fetch = FetchType.LAZY , cascade = [CascadeType.ALL , CascadeType.REMOVE])
    var cartItems: List<CartItem>?=null,
)