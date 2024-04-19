package com.example.bookEcommerce.repository

import com.example.bookEcommerce.base.repository.BaseRepository
import com.example.bookEcommerce.model.Role
import org.springframework.stereotype.Repository
import java.util.Optional


@Repository
interface RoleRepository : BaseRepository<Role , Int> {
    fun findByName(name :String):Optional<Role>
}