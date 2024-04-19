package com.example.bookEcommerce.controller

import com.example.bookEcommerce.base.response.MessageResponse
import com.example.bookEcommerce.base.response.ObjectResponse
import com.example.bookEcommerce.base.response.PageResponse
import com.example.bookEcommerce.dto.AuthorDto
import com.example.bookEcommerce.dto.CartDto
import com.example.bookEcommerce.dto.CartRequest
import com.example.bookEcommerce.model.Book
import com.example.bookEcommerce.model.Cart
import com.example.bookEcommerce.service.CartService
import com.example.bookEcommerce.utils.constants.Constants
import jakarta.validation.Valid
import org.springframework.web.bind.annotation.*


@RestController
@RequestMapping("${Constants.MAIN_URL}cart")
class CartController (
    private val cartService: CartService
){
    @GetMapping
    fun index(
        @RequestParam(name = "userName") userName : String?,
        @RequestParam(defaultValue = "0") page : Int,
        @RequestParam(defaultValue = "10") size : Int,
    ) : PageResponse<CartDto?> {
        return cartService.index(userName , page, size)
    }
    @GetMapping("/{id}")
    fun show(@PathVariable("id") id :Long) : ObjectResponse<CartDto> {
        return cartService.show(id)
    }
    @PostMapping("/create")
    fun create(@Valid @RequestBody newItem : CartRequest): MessageResponse {
        return cartService.create(newItem.bookId , newItem.userId)
    }
    @DeleteMapping("/delete/{user_id}/{book_id}")
    fun deleteById(@PathVariable("user_id") userId :Long,
                   @PathVariable("book_id") bookId :Long) : MessageResponse {
        return cartService.delete(userId = userId , bookId = bookId)
    }
    @DeleteMapping("/deleteAll/{user_id}")
    fun deleteAllByUserId(@PathVariable("user_id") userId : Long) : MessageResponse {
        return cartService.deleteAll(userId)
    }
}