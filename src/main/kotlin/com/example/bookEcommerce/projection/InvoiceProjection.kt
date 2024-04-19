package com.example.bookEcommerce.projection

interface InvoiceProjection {
    fun getUser() : UserProjection
    fun getTotalPrice() : Double
    fun getTotalBook():Int
    fun getInvoiceItems() : List<InvoiceItemProjection>

    interface InvoiceItemProjection{
        fun getBook():BookProjection
        fun getUnitPrice():Float
    }

}


