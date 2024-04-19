package com.example.bookEcommerce.service.impl

import com.example.bookEcommerce.base.response.MessageResponse
import com.example.bookEcommerce.base.response.ObjectResponse
import com.example.bookEcommerce.exception.NotFoundException
import com.example.bookEcommerce.model.Role
import com.example.bookEcommerce.repository.RoleRepository
import com.example.bookEcommerce.service.RoleService
import org.springframework.stereotype.Service

@Service
class RoleServiceImpl(private val roleRepository: RoleRepository) : RoleService {
    override fun show(id: Int): ObjectResponse<Role> {
        val role: Role = roleRepository.findById(id)!!.orElseThrow { NotFoundException("Role with id $id not found") }
        return ObjectResponse(role)
    }

    override fun index(): ObjectResponse<List<Role>> {
        return ObjectResponse(roleRepository.findAll())
    }

    override fun deleteById(id: Int): MessageResponse {
        val role : Role = roleRepository.findById(id)!!.orElseThrow {NotFoundException("Role with id $id not found")}
        roleRepository.delete(role).let { return MessageResponse() }
    }

    override fun create(newRole: Role): MessageResponse {
        roleRepository.save(newRole).let { return MessageResponse() }
    }

    override fun updateById(updatedRole: Role, id: Int): MessageResponse {
        TODO("Not yet implemented")
    }
}