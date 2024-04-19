package com.example.bookEcommerce.projection

import org.springframework.beans.factory.annotation.Value

interface UserProjection {
    fun getId(): Long
    @Value("#{target.firstname + ' ' + target.lastname}")
    fun getFullName(): String
    fun getEmail(): String
    fun getRole() : RoleProjection


    interface RoleProjection{
        fun getId(): Long
        fun getName(): String
    }

}