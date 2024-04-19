package com.example.bookEcommerce.repository

import com.example.bookEcommerce.base.repository.BaseRepository
import com.example.bookEcommerce.model.BookUser
import com.example.bookEcommerce.model.User
import org.springframework.stereotype.Repository
import java.util.Optional

@Repository
interface BookUserRepository : BaseRepository<BookUser, Long> {
    fun findBookUsersByUser(user: User) : Optional<BookUser>?
    fun findBookUserByUserId(userId: Long) : Optional<BookUser>?
}