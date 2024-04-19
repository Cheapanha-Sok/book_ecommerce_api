package com.example.bookEcommerce.service

import com.example.bookEcommerce.base.response.ObjectResponse
import com.example.bookEcommerce.dto.BookUserDto
import com.example.bookEcommerce.model.Book
import com.example.bookEcommerce.model.User

interface BookUserService {
    fun index(username :String , page :Int , size : Int) : ObjectResponse<List<BookUserDto>>
    fun show(userId : Long) : ObjectResponse<BookUserDto>
    fun create(user : User , listBooks : List<Book>)
}