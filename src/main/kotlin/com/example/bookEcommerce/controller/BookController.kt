package com.example.bookEcommerce.controller

import com.example.bookEcommerce.base.response.MessageResponse
import com.example.bookEcommerce.base.response.ObjectResponse
import com.example.bookEcommerce.base.response.PageResponse
import com.example.bookEcommerce.dto.BookDto
import com.example.bookEcommerce.dto.SellDto
import com.example.bookEcommerce.model.Book
import com.example.bookEcommerce.projection.BookProjection
import com.example.bookEcommerce.service.BookService
import com.example.bookEcommerce.utils.constants.Constants
import jakarta.validation.Valid
import org.springframework.web.bind.annotation.*
import org.springframework.web.multipart.MultipartFile

@RestController
@RequestMapping("${Constants.MAIN_URL}book")
class BookController(private val bookService: BookService) {
    @GetMapping
    fun index(
        @RequestParam(name = "name") name : String?,
        @RequestParam(defaultValue = "0") page : Int,
        @RequestParam(defaultValue = "10") size : Int,
    ) : PageResponse<BookDto?> {
        return bookService.index(name , page, size)
    }
    @GetMapping("/{id}")
    fun show(@PathVariable("id") id :Long) : ObjectResponse<BookDto> {
        return bookService.show(id)
    }
    @GetMapping("/projection")
    fun showByProjection() : ObjectResponse<List<BookProjection>>{
        return bookService.findAllByProjection()
    }
    @PostMapping("/create/{category_id}/{author_id}")
    fun create(@Valid newBook: Book,
               @RequestParam("pdfFile" , required = true) pdfFile: MultipartFile,
               @RequestParam("imageFile" , required = true) imageFile: MultipartFile,
               @PathVariable("category_id") categoryId : Int,
               @PathVariable("author_id") authorId : Long): MessageResponse {
        return bookService.create(newBook, pdfFile, imageFile , categoryId , authorId)
    }
    @PostMapping("/sell/{user_id}")
    fun sellBook(@PathVariable("user_id") userId: Long ,@RequestBody sellBike : List<SellDto>) : MessageResponse{
        return bookService.sellBook(userId, sellBike)
    }


    @DeleteMapping("/delete/{id}")
    fun deleteById(@PathVariable("id") id :Long) : MessageResponse {
        return bookService.deleteById(id)
    }
    @PutMapping("/put/{id}")
    fun updateById(@PathVariable("id") id :Long, @RequestBody updatedBook : BookDto): MessageResponse {
        return bookService.updateById(updatedBook,id)
    }
}