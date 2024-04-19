package com.example.bookEcommerce.dto

data class InvoiceDto(
    var id :Long = 0,
    var userId : Long = 0,
    var userName :String,
    var totalItem : Int = 0,
    var totalPrice : Double = 0.00,
    var invoiceItems : List<InvoiceItemDto>
)