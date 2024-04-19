package com.example.bookEcommerce.service

import com.example.bookEcommerce.base.response.MessageResponse
import com.example.bookEcommerce.base.response.ObjectResponse
import com.example.bookEcommerce.base.response.PageResponse
import com.example.bookEcommerce.dto.BookDto
import com.example.bookEcommerce.dto.UserDto
import com.example.bookEcommerce.model.Book
import com.example.bookEcommerce.model.User
import com.example.bookEcommerce.projection.UserProjection

interface UserService {
    fun index (name :String ? , page :Int , size :Int) : PageResponse<UserDto?>
    fun findByProjection():ObjectResponse<List<UserProjection>>
    fun show (id :Long) : ObjectResponse<UserDto>
    fun deleteById(id :Long) : MessageResponse
    fun create(newUser: User , roleId :Int) : MessageResponse
    fun updateById(id:Long,updatedUser : User) : MessageResponse
    fun register(newUser : User) : MessageResponse
}