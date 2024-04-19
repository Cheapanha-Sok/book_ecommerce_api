package com.example.bookEcommerce.service.impl

import com.example.bookEcommerce.base.response.ObjectResponse
import com.example.bookEcommerce.dto.BookUserDto
import com.example.bookEcommerce.dto.mapper.BookUserMapper
import com.example.bookEcommerce.model.Book
import com.example.bookEcommerce.model.BookUser
import com.example.bookEcommerce.model.User
import com.example.bookEcommerce.repository.BookUserRepository
import com.example.bookEcommerce.service.BookUserItemService
import com.example.bookEcommerce.service.BookUserService
import org.springframework.stereotype.Service


@Service
class BookUserServiceImpl(
    private val bookUserRepository: BookUserRepository,
    private val bookUserItemService: BookUserItemService,
    private val bookUserMapper: BookUserMapper
) : BookUserService {
    override fun index(username: String, page: Int, size: Int): ObjectResponse<List<BookUserDto>> {
        TODO("Not yet implemented")
    }

    override fun show(userId: Long): ObjectResponse<BookUserDto> {
        val bookUser = findBookUserByUserId(userId)
        return if (bookUser!!.isPresent) {
            ObjectResponse(bookUserMapper.toDto(bookUser.get()))
        } else {
            ObjectResponse()
        }
    }

    override fun create(user: User, listBooks: List<Book>) {
        val bookUser = findExistingBookUser(user , listBooks.size)
        bookUserRepository.save(bookUser).let { bookUserItemService.create(listBooks , it!!) }
    }
    private fun findExistingBookUser(user : User , totalBook : Int) = bookUserRepository.findBookUsersByUser(user)?.orElseGet {
        BookUser().apply {
            this.user = user
            this.totalBook = totalBook
        }
    }

    private fun findBookUserByUserId(userId : Long) = bookUserRepository.findBookUserByUserId(userId)
}