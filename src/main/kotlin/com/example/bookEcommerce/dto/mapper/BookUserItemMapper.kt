package com.example.bookEcommerce.dto.mapper

import com.example.bookEcommerce.dto.BookUserItemDto
import com.example.bookEcommerce.model.BookUserItem
import org.mapstruct.Mapper
import org.mapstruct.Mapping


@Mapper(componentModel = "spring")
interface BookUserItemMapper {
    @Mapping(target = "bookName", source = "book.name")
    @Mapping(target = "bookCover", source = "book.bookCover")
    @Mapping(target = "bookUrl" , source = "book.bookPdf")
    @Mapping(target = "category" , source = "book.category.name")
    fun toDto(bookUserItem: BookUserItem): BookUserItemDto
}