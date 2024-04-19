package com.example.bookEcommerce.dto.mapper.impl

import com.example.bookEcommerce.dto.BookUserDto
import com.example.bookEcommerce.dto.mapper.BookUserItemMapper
import com.example.bookEcommerce.dto.mapper.BookUserMapper
import com.example.bookEcommerce.model.BookUser
import org.springframework.stereotype.Component


@Component
class BookUserMapperImpl(
    private val bookUserItemMapper: BookUserItemMapper
)  : BookUserMapper {
    override fun toDto(bookUser: BookUser): BookUserDto {
        return BookUserDto(
            id = bookUser.id,
            username = bookUser.user?.firstName + " " + bookUser.user?.lastName,
            totalBooks = bookUser.bookUserItems?.size,
            bookItem = bookUser.bookUserItems!!.map { bookUserItemMapper.toDto(it) }
        )
    }

}