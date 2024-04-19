package com.example.bookEcommerce.service.impl

import com.example.bookEcommerce.base.response.MessageResponse
import com.example.bookEcommerce.base.response.ObjectResponse
import com.example.bookEcommerce.base.response.PageResponse
import com.example.bookEcommerce.dto.*
import com.example.bookEcommerce.dto.mapper.BookMapper
import com.example.bookEcommerce.exception.NotFoundException
import com.example.bookEcommerce.model.Book
import com.example.bookEcommerce.projection.BookProjection
import com.example.bookEcommerce.repository.AuthorRepository
import com.example.bookEcommerce.repository.BookRepository
import com.example.bookEcommerce.repository.CategoryRepository
import com.example.bookEcommerce.repository.UserRepository
import com.example.bookEcommerce.service.BookService
import com.example.bookEcommerce.service.BookUserService
import com.example.bookEcommerce.service.CloudinaryService
import com.example.bookEcommerce.service.InvoiceService
import jakarta.persistence.criteria.Predicate
import org.springframework.data.domain.PageRequest
import org.springframework.stereotype.Service
import org.springframework.web.multipart.MultipartFile

@Service
class BookServiceImpl (
    private val bookRepository: BookRepository,
    private val userRepository: UserRepository,
    private val cloudinaryService: CloudinaryService,
    private val categoryRepository: CategoryRepository,
    private val authorRepository: AuthorRepository,
    private val invoiceService: InvoiceService,
    private val bookMapper: BookMapper,
    private val bookUserService: BookUserService) : BookService {
    override fun index(name: String?, page: Int, size: Int): PageResponse<BookDto?> {
        val books = bookRepository.findAll({root , query , builder->
            val predicates = ArrayList<Predicate>()
            name?.let {
                predicates.add(builder.like(builder.lower(root.get("name")),"%${it.lowercase()}%"))
            }
            query.orderBy(builder.desc(root.get<Long>("id")))
            builder.and(*predicates.toTypedArray())
        },PageRequest.of(page , size))

        return PageResponse(books.totalElements , books.content.map { bookMapper.toDto(it) })
    }

    override fun show(id: Long): ObjectResponse<BookDto> {
        val book : Book = bookRepository.findById(id)!!.orElseThrow { NotFoundException("Book not found with id $id") }
        return ObjectResponse(bookMapper.toDto(book))
    }

    override fun deleteById(id: Long): MessageResponse {
        val book : Book = bookRepository.findById(id)!!.orElseThrow { NotFoundException("Book not found with id $id") }
        val isDeletedPdf = cloudinaryService.removeFile("pdf" , book.name!!)
        val isDeletedImage = cloudinaryService.removeFile("image" , book.name!!)
        if (isDeletedImage && isDeletedPdf){
            bookRepository.delete(book).let { return MessageResponse() }
        }
        throw RuntimeException("Something when wrong")
    }

    override fun create(newBook: Book , pdfFile : MultipartFile , imageFile: MultipartFile , categoryId :Int , authorId :Long): MessageResponse {
        val category = categoryRepository.findById(categoryId)!!.orElseThrow { NotFoundException("Category not found with id $categoryId") }
        val author = authorRepository.findById(authorId)!!.orElseThrow { NotFoundException("Author not found with id $authorId") }
        val pdfUrl = cloudinaryService.uploadFile(pdfFile , "pdf" , newBook.name!!)
        val imageUrl = cloudinaryService.uploadFile(imageFile , "image" ,newBook.name!!)
        if (pdfUrl !=null && imageUrl !=null){
            newBook.bookPdf = pdfUrl
            newBook.author = author
            newBook.category = category
            newBook.bookCover = imageUrl
            bookRepository.save(newBook).let { return MessageResponse() }
        }else
            throw RuntimeException("Something when wrong during add file to cloud")
    }

    override fun updateById(updatedBook: BookDto , id: Long): MessageResponse {
        TODO("Not yet implemented")
    }

    private fun findBook(bookId : Long) = bookRepository.findById(bookId)!!.orElseThrow { NotFoundException("Book not found with id $bookId") }

    private fun userIsExist(userId : Long) = userRepository.findById(userId)!!.orElseThrow { NotFoundException("User not found with id $userId") }

    override fun sellBook(userId: Long, sellBike: List<SellDto>) : MessageResponse {
        val user = userIsExist(userId)
        var totalPrice: Double = 0.00
        val books: List<Book> = sellBike.map {
            findBook(it.bookId)
        }
        books.map {
            totalPrice += it.price!!
        }
        bookUserService.create(user, books).let {
            invoiceService.create(books, totalPrice, books.size, user).let { return MessageResponse() }
        }
    }

    override fun findAllByProjection(): ObjectResponse<List<BookProjection>> {
        bookRepository.findAllBookBy().let { return ObjectResponse(it) }

    }
}