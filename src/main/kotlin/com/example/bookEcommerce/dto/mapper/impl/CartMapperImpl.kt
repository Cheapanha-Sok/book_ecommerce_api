package com.example.bookEcommerce.dto.mapper.impl

import com.example.bookEcommerce.dto.CartDto
import com.example.bookEcommerce.dto.mapper.CartItemMapper
import com.example.bookEcommerce.dto.mapper.CartMapper
import com.example.bookEcommerce.model.Cart
import org.springframework.stereotype.Component


@Component
class CartMapperImpl(private val cartItemMapper: CartItemMapper) : CartMapper {
    override fun toDto(entity: Cart): CartDto {
        return CartDto(
            id = entity.id!!,
            fullName = entity.user?.firstName + entity.user?.lastName,
            userId = entity.user?.id!!,
            totalPrice = entity.totalPrice!!.toDouble(),
            cartItem = entity.cartItems!!.map { cartItemMapper.toDto(it) }
        )
    }
}