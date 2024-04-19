package com.example.bookEcommerce.service.impl

import com.example.bookEcommerce.model.Book
import com.example.bookEcommerce.model.BookUser
import com.example.bookEcommerce.model.BookUserItem
import com.example.bookEcommerce.repository.BookUserItemRepository
import com.example.bookEcommerce.service.BookUserItemService
import org.springframework.stereotype.Service


@Service
class BookUserItemServiceImpl(
    private val bookUserItemRepository: BookUserItemRepository
) : BookUserItemService {
    override fun create(listBooks: List<Book>, bookUser: BookUser) {
        val bookUserItems : ArrayList<BookUserItem> = ArrayList()
        listBooks.map {
            val bookUserItem: BookUserItem = BookUserItem().apply {
                this.bookUser = bookUser
                this.book = it
            }
            bookUserItems.add(bookUserItem)
        }
        bookUserItemRepository.saveAll(bookUserItems)
    }
}