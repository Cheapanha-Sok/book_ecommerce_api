package com.example.bookEcommerce.dto

data class BookUserDto(
    var id: Long? = 0,
    var username :String?=null,
    var totalBooks : Int? = 0,
    var bookItem : List<BookUserItemDto>
)
