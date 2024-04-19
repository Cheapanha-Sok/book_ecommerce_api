package com.example.bookEcommerce.controller

import com.example.bookEcommerce.base.response.MessageResponse
import com.example.bookEcommerce.base.response.ObjectResponse
import com.example.bookEcommerce.base.response.PageResponse
import com.example.bookEcommerce.dto.BookDto
import com.example.bookEcommerce.dto.UserDto
import com.example.bookEcommerce.model.Category
import com.example.bookEcommerce.model.User
import com.example.bookEcommerce.projection.UserProjection
import com.example.bookEcommerce.service.UserService
import com.example.bookEcommerce.utils.constants.Constants
import jakarta.validation.Valid
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("${Constants.MAIN_URL}user")
class UserController (private val userService: UserService) {
    @GetMapping
    fun index(
        @RequestParam(name = "name") name : String?,
        @RequestParam(defaultValue = "0") page : Int,
        @RequestParam(defaultValue = "10") size : Int,
    ) : PageResponse<UserDto?> {
        return userService.index(name , page, size)
    }
    @GetMapping("/{id}")
    fun show(@PathVariable("id") id :Long) : ObjectResponse<UserDto> {
        return userService.show(id)
    }
    @GetMapping("/projection")
    fun findByProjection() : ObjectResponse<List<UserProjection>> {
        return userService.findByProjection()
    }
    @PostMapping("/register")
    fun register(@Valid @RequestBody newUser: User) : MessageResponse{
        return userService.register(newUser)
    }
    @PostMapping("/create/{role_id}")
    fun create(@RequestBody newUser : User , @PathVariable("role_id") roleId :Int): MessageResponse {
        return userService.create(newUser = newUser , roleId = roleId)
    }
    @DeleteMapping("/delete/{id}")
    fun deleteById(@PathVariable("id") id :Long) : MessageResponse {
        return userService.deleteById(id)
    }
    @PutMapping("/put/{id}")
    fun updateById(@PathVariable("id") id :Long, @RequestBody updatedUser : User): MessageResponse {
        return userService.updateById(id , updatedUser)
    }
}