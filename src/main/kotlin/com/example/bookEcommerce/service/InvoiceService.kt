package com.example.bookEcommerce.service

import com.example.bookEcommerce.base.response.ObjectResponse
import com.example.bookEcommerce.dto.InvoiceDto
import com.example.bookEcommerce.model.Book
import com.example.bookEcommerce.model.User
import com.example.bookEcommerce.projection.InvoiceProjection

interface InvoiceService {
    fun findByProjection() : ObjectResponse<List<InvoiceProjection>>
    fun create(books : List<Book> , totalPrice : Double , totalBook : Int , user : User)
    fun index() : ObjectResponse<List<InvoiceDto>>
}