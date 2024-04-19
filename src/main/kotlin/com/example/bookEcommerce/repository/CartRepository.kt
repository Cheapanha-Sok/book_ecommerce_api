package com.example.bookEcommerce.repository

import com.example.bookEcommerce.base.repository.BaseRepository
import com.example.bookEcommerce.model.Cart
import com.example.bookEcommerce.model.User
import org.springframework.stereotype.Repository
import java.util.Optional

@Repository
interface CartRepository : BaseRepository<Cart , Long> {
    fun findCartByUserId(userId: Long): Optional<Cart>?
}