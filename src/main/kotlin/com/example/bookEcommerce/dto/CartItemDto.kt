package com.example.bookEcommerce.dto

data class CartItemDto(
    var id: Long? = 0,
    var unitPrice : Double= 0.0,
    var bookId : Long? = 0,
    var bookName : String
)