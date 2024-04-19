package com.example.bookEcommerce.dto.mapper

import com.example.bookEcommerce.dto.UserDto
import com.example.bookEcommerce.model.User
import org.mapstruct.Mapper
import org.mapstruct.Mapping


@Mapper(componentModel = "spring")
interface UserMapper {
    @Mapping(target = "role" , source = "role.name")
    @Mapping(target = "fullName", expression = "java(user.getFirstName() + ' ' + user.getLastName())")
    fun toDto(user : User) : UserDto

}