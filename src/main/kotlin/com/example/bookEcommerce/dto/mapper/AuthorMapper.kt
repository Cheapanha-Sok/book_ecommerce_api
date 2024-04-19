package com.example.bookEcommerce.dto.mapper

import com.example.bookEcommerce.dto.AuthorDto
import com.example.bookEcommerce.model.Author
import org.mapstruct.Mapper

@Mapper(componentModel = "spring")
interface AuthorMapper {
    fun toDto(author: Author): AuthorDto
    fun toModel(authorDto: AuthorDto): Author
}