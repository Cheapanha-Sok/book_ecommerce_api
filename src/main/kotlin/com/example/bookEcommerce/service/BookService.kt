package com.example.bookEcommerce.service

import com.example.bookEcommerce.base.response.MessageResponse
import com.example.bookEcommerce.base.response.ObjectResponse
import com.example.bookEcommerce.base.response.PageResponse
import com.example.bookEcommerce.dto.BookDto
import com.example.bookEcommerce.dto.SellDto
import com.example.bookEcommerce.model.Book
import com.example.bookEcommerce.projection.BookProjection
import org.springframework.web.multipart.MultipartFile

interface BookService {
    fun index (name :String ? , page :Int , size :Int) : PageResponse<BookDto?>
    fun show (id :Long) : ObjectResponse<BookDto>
    fun deleteById(id :Long) : MessageResponse
    fun create(newBook: Book, pdfFile : MultipartFile, imageFile: MultipartFile , categoryId :Int ,authorId :Long ) : MessageResponse
    fun updateById(updatedBook : BookDto , id: Long) : MessageResponse
    fun sellBook(userId : Long , sellBike : List<SellDto>) : MessageResponse
    fun findAllByProjection() : ObjectResponse<List<BookProjection>>
}