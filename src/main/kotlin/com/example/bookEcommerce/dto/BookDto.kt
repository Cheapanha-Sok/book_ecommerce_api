package com.example.bookEcommerce.dto

data class BookDto(
    val id :Long,
    var price : Float,
    var name : String,
    var category: String,
    var bookPdf : String,
    var bookCover :String,
    var author :String,
)