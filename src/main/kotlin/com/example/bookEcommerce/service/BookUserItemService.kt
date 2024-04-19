package com.example.bookEcommerce.service

import com.example.bookEcommerce.model.Book
import com.example.bookEcommerce.model.BookUser

interface BookUserItemService {
    fun create(listBooks: List<Book> , bookUser: BookUser)
}