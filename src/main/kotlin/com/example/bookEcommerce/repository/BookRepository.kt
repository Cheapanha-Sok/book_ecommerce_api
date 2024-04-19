package com.example.bookEcommerce.repository

import com.example.bookEcommerce.base.repository.BaseRepository
import com.example.bookEcommerce.model.Book
import com.example.bookEcommerce.projection.BookProjection
import org.springframework.stereotype.Repository

@Repository
interface BookRepository : BaseRepository<Book , Long>{
    fun findAllBookBy() :List<BookProjection>
}