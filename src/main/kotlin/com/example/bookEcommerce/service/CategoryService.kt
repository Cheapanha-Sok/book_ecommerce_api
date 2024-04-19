package com.example.bookEcommerce.service

import com.example.bookEcommerce.base.response.MessageResponse
import com.example.bookEcommerce.base.response.ObjectResponse
import com.example.bookEcommerce.model.Category

interface CategoryService {
    fun index () : ObjectResponse<List<Category>>
    fun show (id :Int) : ObjectResponse<Category>
    fun deleteById(id :Int) : MessageResponse
    fun create(newCategory : Category) : MessageResponse
    fun updateById( id: Int,updatedCategory : Category) : MessageResponse
}