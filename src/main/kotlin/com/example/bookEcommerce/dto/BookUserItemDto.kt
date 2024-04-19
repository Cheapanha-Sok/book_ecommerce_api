package com.example.bookEcommerce.dto

data class BookUserItemDto(
    var id: Long? = 0,
    var bookName : String?=null,
    var bookCover : String?=null,
    var bookUrl : String?=null,
    var category: String?=null
)