package com.example.bookEcommerce.service.impl

import com.example.bookEcommerce.base.response.MessageResponse
import com.example.bookEcommerce.base.response.ObjectResponse
import com.example.bookEcommerce.base.response.PageResponse
import com.example.bookEcommerce.dto.CartDto
import com.example.bookEcommerce.dto.mapper.CartMapper
import com.example.bookEcommerce.exception.NotFoundException
import com.example.bookEcommerce.model.Cart
import com.example.bookEcommerce.repository.BookRepository
import com.example.bookEcommerce.repository.CartRepository
import com.example.bookEcommerce.repository.UserRepository
import com.example.bookEcommerce.service.CartItemService
import com.example.bookEcommerce.service.CartService
import org.springframework.stereotype.Service

@Service
class CartServiceImpl(
    private val cartRepository: CartRepository,
    private val cartMapper: CartMapper,
    private val userRepository: UserRepository,
    private val bookRepository: BookRepository,
    private val cartItemService: CartItemService,

) : CartService {
    override fun index(userName: String?, page: Int, size: Int): PageResponse<CartDto?> {
        TODO("Not yet implemented")
    }

    override fun show(userId: Long): ObjectResponse<CartDto> {
        val cart = cartRepository.findCartByUserId(userId)
        return if (cart!!.isPresent){
            ObjectResponse(cartMapper.toDto(cart.get()))
        }else
            ObjectResponse()
    }

    override fun delete(userId: Long , bookId : Long): MessageResponse {
        val cart = existCart(userId)
        val book = findBook(bookId)
        if (cart!!.isPresent){
            cart.get().totalPrice = cart.get().totalPrice?.minus(book.price!!)
            cartItemService.deleteByBook(book).let { return MessageResponse() }
        }else
            throw NotFoundException("cart with user id $userId not found")
    }

    private fun findBook(bookId: Long) =
        bookRepository.findById(bookId)!!.orElseThrow { NotFoundException("Book with id $bookId not found") }

    private fun existUser(userId: Long) =
        userRepository.findById(userId)!!.orElseThrow { NotFoundException("User with id $userId not found") }

    private fun existCart(userId: Long) = cartRepository.findCartByUserId(userId)

    override fun create(bookId: Long, userId: Long): MessageResponse {
        val user = existUser(userId)
        val book = findBook(bookId)
        val cart = existCart(userId)
        if (cart!!.isPresent){
            cart.get().totalPrice = cart.get().totalPrice?.plus(book.price!!)
            cartRepository.save(cart.get()).let { cartItemService.create(it , book) }
        }else{
            val newCart = Cart().apply {
                this.totalPrice = book.price?.toDouble()
                this.user = user
            }
            cartRepository.save(newCart).let { cartItemService.create(it , book) }
        }
        return MessageResponse()
    }

    override fun deleteAll(userId: Long) :MessageResponse {
        val cart = existCart(userId)
        if (cart!!.isPresent){
            cart.get().totalPrice = 0.00
            cartItemService.deleteAllByCart(cart = cart.get()).let { return MessageResponse() }
        }else
            throw NotFoundException("cart with user id $userId not found")
    }
}