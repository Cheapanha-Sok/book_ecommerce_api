package com.example.bookEcommerce.service.impl

import com.example.bookEcommerce.base.response.MessageResponse
import com.example.bookEcommerce.base.response.ObjectResponse
import com.example.bookEcommerce.exception.NotFoundException
import com.example.bookEcommerce.model.Category
import com.example.bookEcommerce.repository.CategoryRepository
import com.example.bookEcommerce.service.CategoryService
import org.springframework.stereotype.Service

@Service
class CategoryServiceImpl (private val categoryRepository: CategoryRepository) : CategoryService {
    override fun index()  : ObjectResponse<List<Category>>{
        categoryRepository.findAll().let { return ObjectResponse(it) }
    }
    override fun show(id: Int): ObjectResponse<Category> {
        val category : Category = categoryRepository.findById(id)!!.orElseThrow { NotFoundException("Category not found with id $id") }
        return ObjectResponse(category)
    }

    override fun create(newCategory: Category) : MessageResponse{
        categoryRepository.save(newCategory).let { return MessageResponse() }
    }

    override fun deleteById(id: Int) : MessageResponse {
        val category : Category = categoryRepository.findById(id)!!.orElseThrow { NotFoundException("Category not found with id $id") }
        categoryRepository.delete(category).let { return MessageResponse() }
    }

    override fun updateById(id: Int, updatedCategory: Category) : MessageResponse {
        val category : Category = categoryRepository.findById(id)!!.orElseThrow { NotFoundException("Category not found with id $id") }
        updatedCategory.name?.let { category.name = updatedCategory.name }
        categoryRepository.save(category).let { return MessageResponse() }
    }
}