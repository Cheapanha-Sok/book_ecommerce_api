package com.example.bookEcommerce.dto.mapper

import com.example.bookEcommerce.dto.BookUserDto
import com.example.bookEcommerce.model.BookUser
import org.mapstruct.Mapper

@Mapper
interface BookUserMapper {
    fun toDto(bookUser: BookUser) : BookUserDto
}