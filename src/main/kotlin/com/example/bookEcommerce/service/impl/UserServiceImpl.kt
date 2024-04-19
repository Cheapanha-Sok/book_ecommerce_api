package com.example.bookEcommerce.service.impl

import com.example.bookEcommerce.base.response.MessageResponse
import com.example.bookEcommerce.base.response.ObjectResponse
import com.example.bookEcommerce.base.response.PageResponse
import com.example.bookEcommerce.dto.UserDto
import com.example.bookEcommerce.dto.mapper.UserMapper
import com.example.bookEcommerce.exception.NotFoundException
import com.example.bookEcommerce.model.Role
import com.example.bookEcommerce.model.User
import com.example.bookEcommerce.projection.UserProjection
import com.example.bookEcommerce.repository.RoleRepository
import com.example.bookEcommerce.repository.UserRepository
import com.example.bookEcommerce.service.UserService
import jakarta.persistence.criteria.Predicate
import org.springframework.data.domain.PageRequest
import org.springframework.stereotype.Service

@Service
class UserServiceImpl(
    private val userRepository: UserRepository,
    private val roleRepository: RoleRepository,
    private val userMapper: UserMapper
    ) : UserService {

    override fun show(id: Long): ObjectResponse<UserDto> {
        val account = userRepository.findById(id)!!.orElseThrow { NotFoundException("Account not found with id $id") }
        return ObjectResponse(userMapper.toDto(account))
    }

    override fun index(name :String ? , page :Int , size :Int): PageResponse<UserDto?> {
        val account = userRepository.findAll({root , cq , cb ->
            val predicates = ArrayList<Predicate>()
            name?.let {
                predicates.add(cb.like(cb.lower(root.get("name")),"%${it.lowercase()}%"))
            }
            cq.orderBy(cb.desc(root.get<Long>("id")))
            cb.and(*predicates.toTypedArray())
        },PageRequest.of(page,size))
        return PageResponse(account.totalElements , account.content.map { userMapper.toDto(it) })
    }

    override fun findByProjection(): ObjectResponse<List<UserProjection>> {
        userRepository.findAllUserBy().let { return ObjectResponse(it) }
    }

    override fun deleteById(id: Long): MessageResponse {
        val account = userRepository.findById(id)?.orElseThrow { NotFoundException("Account not found with id $id") }
        userRepository.delete(account!!).let { return MessageResponse() }
    }


    override fun register(newUser: User): MessageResponse {
        val role = roleRepository.findByName("USER").orElseThrow { NotFoundException("Role not found with name User") }
        newUser.role = role
        userRepository.save(newUser).let { return MessageResponse() }
    }

    override fun create(newUser: User , roleId :Int): MessageResponse {
        val role = roleRepository.findById(roleId)!!.orElseThrow { NotFoundException("Role not found with id $roleId") }
        newUser.role = role
        userRepository.save(newUser).let { return MessageResponse() }
    }

    override fun updateById(id: Long, updatedUser: User): MessageResponse {
        TODO("Not yet implemented")
    }

    private fun findRoleById(id:Int) : Role?{
        return roleRepository.findById(id)?.orElseThrow{ NotFoundException("Role not found with id $id") }
    }
}