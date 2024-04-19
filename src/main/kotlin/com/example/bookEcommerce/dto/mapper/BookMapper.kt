package com.example.bookEcommerce.dto.mapper

import com.example.bookEcommerce.dto.BookDto
import com.example.bookEcommerce.model.Book
import org.mapstruct.Mapper
import org.mapstruct.Mapping


@Mapper(componentModel = "spring")
interface BookMapper {
    @Mapping(target = "category", source = "category.name")
    @Mapping(target = "author", source = "author.name")
    fun toDto(book: Book): BookDto
}