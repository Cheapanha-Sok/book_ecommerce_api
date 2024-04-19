package com.example.bookEcommerce.dto.mapper

import com.example.bookEcommerce.dto.InvoiceItemDto
import com.example.bookEcommerce.model.Book
import com.example.bookEcommerce.model.Invoice
import com.example.bookEcommerce.model.InvoiceItem
import jakarta.persistence.*
import org.mapstruct.Mapper
import org.mapstruct.Mapping


@Mapper(componentModel = "spring")
interface InvoiceItemMapper {
    @Mapping(target = "bookId", source = "book.id")
    @Mapping(target = "bookName" , source = "book.name")
    fun toDto(entity: InvoiceItem): InvoiceItemDto
}