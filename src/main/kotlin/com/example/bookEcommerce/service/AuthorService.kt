package com.example.bookEcommerce.service

import com.example.bookEcommerce.base.response.MessageResponse
import com.example.bookEcommerce.base.response.ObjectResponse
import com.example.bookEcommerce.base.response.PageResponse
import com.example.bookEcommerce.dto.AuthorDto

interface AuthorService {
    fun index (name :String ? , page :Int , size :Int) : PageResponse<AuthorDto?>
    fun show (id :Long) : ObjectResponse<AuthorDto>
    fun deleteById(id :Long) : MessageResponse
    fun create(newAuthor : AuthorDto) : MessageResponse
    fun updateById(id :Long,updatedAuthor: AuthorDto) : MessageResponse
}