package com.example.bookEcommerce.repository

import com.example.bookEcommerce.base.repository.BaseRepository
import com.example.bookEcommerce.model.Category
import org.springframework.stereotype.Repository

@Repository
interface CategoryRepository : BaseRepository<Category , Int>