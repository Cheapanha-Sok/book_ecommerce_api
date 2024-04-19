package com.example.bookEcommerce.dto

import com.example.bookEcommerce.model.Author
import jakarta.validation.constraints.NotBlank


data class AuthorDto(
    var id :Long,
    @field:NotBlank(message = "The author name is require")
    var name :String,
    @field:NotBlank(message = "The author gender is require")
    var gender :String,
)