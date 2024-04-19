package com.example.bookEcommerce.controller;


import com.example.bookEcommerce.base.response.ObjectResponse
import com.example.bookEcommerce.dto.BookUserDto
import com.example.bookEcommerce.service.BookUserService
import com.example.bookEcommerce.utils.constants.Constants
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("${Constants.MAIN_URL}bookUser")
class BookUserController(
    private val bookUserService: BookUserService
) {
    @GetMapping
    fun getBookUsers(
        @RequestParam(value = "page", defaultValue = "0") page: Int,
        @RequestParam(value = "size", defaultValue = "10") size: Int,
        @RequestParam(value = "username", required = false) username: String?
    ) {

    }

    @GetMapping("{userId}")
    fun getBookUserById(@PathVariable(value = "userId", required = true) userId: Long) : ObjectResponse<BookUserDto> {
        return bookUserService.show(userId = userId)
    }
}
