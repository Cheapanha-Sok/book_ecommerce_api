package com.example.bookEcommerce.service

import com.example.bookEcommerce.model.Book
import com.example.bookEcommerce.model.Invoice

interface InvoiceItemService {
    fun create(books : List<Book> , invoice : Invoice)
}