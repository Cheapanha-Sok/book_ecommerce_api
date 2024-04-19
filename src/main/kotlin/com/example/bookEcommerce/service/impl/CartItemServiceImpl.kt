package com.example.bookEcommerce.service.impl

import com.example.bookEcommerce.exception.NotFoundException
import com.example.bookEcommerce.model.Book
import com.example.bookEcommerce.model.Cart
import com.example.bookEcommerce.model.CartItem
import com.example.bookEcommerce.repository.CartItemRepository
import com.example.bookEcommerce.service.CartItemService
import org.springframework.stereotype.Service


@Service
class CartItemServiceImpl(
    private val cartItemRepository: CartItemRepository,
) : CartItemService {
    override fun create(cart: Cart, book: Book) {
        val cartItem = CartItem().apply {
            this.cart = cart
            this.book = book
            this.unitPrice = book.price!!
        }
        cartItemRepository.save(cartItem)
    }

    override fun deleteByBook(book: Book) {
        val cartItem = cartItemRepository.findByBook(book)?.orElseThrow { NotFoundException("Book with ${book.id} not found in cart") }
        cartItemRepository.delete(cartItem!!)
    }

    override fun deleteAllByCart(cart: Cart) {
        val cartItem = cartItemRepository.findByCart(cart).orEmpty()
        if (cartItem.isNotEmpty()) {
            cartItem.map {
                cartItemRepository.delete(it)
            }
        } else
            throw NotFoundException("Your cart is empty")
    }

}