package com.example.bookEcommerce.service

import com.example.bookEcommerce.base.response.MessageResponse
import com.example.bookEcommerce.base.response.ObjectResponse
import com.example.bookEcommerce.model.Role

interface RoleService {
    fun index() : ObjectResponse<List<Role>>
    fun show(id : Int): ObjectResponse<Role>
    fun deleteById(id:Int) : MessageResponse
    fun create(newRole : Role) : MessageResponse
    fun updateById(updatedRole : Role, id:Int) : MessageResponse
}