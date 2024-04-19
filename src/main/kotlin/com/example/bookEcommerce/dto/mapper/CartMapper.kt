package com.example.bookEcommerce.dto.mapper

import com.example.bookEcommerce.dto.CartDto
import com.example.bookEcommerce.model.Cart
import org.mapstruct.Mapper

@Mapper
interface CartMapper {
    fun toDto(entity: Cart): CartDto
}