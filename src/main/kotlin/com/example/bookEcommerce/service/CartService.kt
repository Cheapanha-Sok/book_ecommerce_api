package com.example.bookEcommerce.service

import com.example.bookEcommerce.base.response.MessageResponse
import com.example.bookEcommerce.base.response.ObjectResponse
import com.example.bookEcommerce.base.response.PageResponse
import com.example.bookEcommerce.dto.CartDto

interface CartService {
    fun index (userName :String ? , page :Int , size :Int) : PageResponse<CartDto?>
    fun show (userId: Long) : ObjectResponse<CartDto>
    fun delete(userId: Long , bookId : Long) : MessageResponse
    fun create(bookId :Long , userId : Long) : MessageResponse
    fun deleteAll(userId: Long) : MessageResponse
}