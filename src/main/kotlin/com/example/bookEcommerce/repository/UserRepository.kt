package com.example.bookEcommerce.repository

import com.example.bookEcommerce.base.repository.BaseRepository
import com.example.bookEcommerce.model.User
import com.example.bookEcommerce.projection.UserProjection
import org.springframework.data.jpa.repository.Query
import org.springframework.stereotype.Repository

@Repository
interface UserRepository : BaseRepository<User , Long>{
    @Query("select user from User " +
            " user join fetch user.role")
    fun findAllUserBy() : List<UserProjection>
}