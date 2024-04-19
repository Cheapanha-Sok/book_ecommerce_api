package com.example.bookEcommerce.service

import com.example.bookEcommerce.model.Book
import com.example.bookEcommerce.model.Cart

interface CartItemService {
    fun create(cart : Cart , book: Book)
    fun deleteByBook(book: Book)
    fun deleteAllByCart(cart : Cart)
}