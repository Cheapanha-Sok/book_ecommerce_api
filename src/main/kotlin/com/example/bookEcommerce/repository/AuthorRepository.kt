package com.example.bookEcommerce.repository

import com.example.bookEcommerce.base.repository.BaseRepository
import com.example.bookEcommerce.model.Author
import org.springframework.stereotype.Repository

@Repository
interface AuthorRepository : BaseRepository<Author , Long>