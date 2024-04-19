package com.example.bookEcommerce.repository

import com.example.bookEcommerce.base.repository.BaseRepository
import com.example.bookEcommerce.model.BookUserItem
import org.springframework.stereotype.Repository

@Repository
interface BookUserItemRepository : BaseRepository<BookUserItem, Long>