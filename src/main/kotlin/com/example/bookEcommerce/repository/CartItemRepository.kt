package com.example.bookEcommerce.repository

import com.example.bookEcommerce.base.repository.BaseRepository
import com.example.bookEcommerce.model.Book
import com.example.bookEcommerce.model.Cart
import com.example.bookEcommerce.model.CartItem
import org.springframework.stereotype.Repository
import java.util.*

@Repository
interface CartItemRepository : BaseRepository<CartItem , Long>{
    fun findByBook(book: Book) : Optional<CartItem>?
    fun findByCart(cart: Cart) : List<CartItem>?

}