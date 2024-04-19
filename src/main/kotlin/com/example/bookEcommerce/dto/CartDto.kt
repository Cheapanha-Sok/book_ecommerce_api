package com.example.bookEcommerce.dto

data class CartDto(
    var id :Long=0,
    var userId :Long=0,
    var totalPrice : Double=0.00,
    var fullName : String,
    var cartItem : List<CartItemDto>,
)
