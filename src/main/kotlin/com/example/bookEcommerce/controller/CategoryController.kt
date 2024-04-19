package com.example.bookEcommerce.controller

import com.example.bookEcommerce.base.response.MessageResponse
import com.example.bookEcommerce.base.response.ObjectResponse
import com.example.bookEcommerce.model.Category
import com.example.bookEcommerce.service.CategoryService
import com.example.bookEcommerce.utils.constants.Constants
import org.springframework.web.bind.annotation.*
@RestController
@RequestMapping("${Constants.MAIN_URL}category")
class CategoryController (private val categoryService: CategoryService) {
    @GetMapping
    fun index() : ObjectResponse<List<Category>>{
        return categoryService.index()
    }
    @GetMapping("/{id}")
    fun show(@PathVariable("id") id :Int) : ObjectResponse<Category>{
        return categoryService.show(id)
    }
    @PostMapping("/create")
    fun create(@RequestBody newCategory : Category): MessageResponse {
        return categoryService.create(newCategory)
    }
    @DeleteMapping("/delete/{id}")
    fun deleteById(@PathVariable("id") id :Int) : MessageResponse{
        return categoryService.deleteById(id)
    }
    @PutMapping("/put/{id}")
    fun updateById(@PathVariable("id") id :Int, @RequestBody updatedCategory : Category): MessageResponse{
        return categoryService.updateById(id , updatedCategory)
    }
}