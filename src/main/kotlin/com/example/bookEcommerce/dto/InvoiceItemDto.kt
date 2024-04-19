package com.example.bookEcommerce.dto

data class InvoiceItemDto(
    var id : Long =0,
    var unitPrice : Float =0.0f,
    var bookId : Long =0,
    var bookName : String
)