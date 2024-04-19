package com.example.bookEcommerce.dto.mapper

import com.example.bookEcommerce.dto.CartItemDto
import com.example.bookEcommerce.model.CartItem
import org.mapstruct.Mapper
import org.mapstruct.Mapping


@Mapper(componentModel = "spring")
interface CartItemMapper {
    @Mapping(target = "bookName" , source = "book.name")
    @Mapping(target = "bookId" , source = "book.id")
    fun toDto(cartItem: CartItem): CartItemDto
}