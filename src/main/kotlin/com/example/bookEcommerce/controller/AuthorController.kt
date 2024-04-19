package com.example.bookEcommerce.controller

import com.example.bookEcommerce.base.response.MessageResponse
import com.example.bookEcommerce.base.response.ObjectResponse
import com.example.bookEcommerce.base.response.PageResponse
import com.example.bookEcommerce.dto.AuthorDto
import com.example.bookEcommerce.model.Author
import com.example.bookEcommerce.service.AuthorService
import com.example.bookEcommerce.utils.constants.Constants
import jakarta.validation.Valid
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("${Constants.MAIN_URL}author")
class AuthorController(private val authorService: AuthorService) {
    @GetMapping
    fun index(
        @RequestParam(name = "name") name : String?,
        @RequestParam(defaultValue = "0") page : Int,
        @RequestParam(defaultValue = "10") size : Int,
              ) : PageResponse<AuthorDto?>{
        return authorService.index(name , page, size)
    }
    @GetMapping("/{id}")
    fun show(@PathVariable("id") id :Long) : ObjectResponse<AuthorDto> {
        return authorService.show(id)
    }
    @PostMapping("/create")
    fun create(@Valid @RequestBody newAuthor : AuthorDto): MessageResponse {
        return authorService.create(newAuthor)
    }
    @DeleteMapping("/delete/{id}")
    fun deleteById(@PathVariable("id") id :Long) : MessageResponse {
        return authorService.deleteById(id)
    }
    @PutMapping("/put/{id}")
    fun updateById(@PathVariable("id") id :Long, @RequestBody updatedAuthor : AuthorDto): MessageResponse {
        return authorService.updateById(id , updatedAuthor)
    }
}