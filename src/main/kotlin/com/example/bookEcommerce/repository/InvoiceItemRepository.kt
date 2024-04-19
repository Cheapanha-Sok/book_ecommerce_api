package com.example.bookEcommerce.repository

import com.example.bookEcommerce.base.repository.BaseRepository
import com.example.bookEcommerce.model.InvoiceItem
import org.springframework.stereotype.Repository

@Repository
interface InvoiceItemRepository : BaseRepository<InvoiceItem , Long>