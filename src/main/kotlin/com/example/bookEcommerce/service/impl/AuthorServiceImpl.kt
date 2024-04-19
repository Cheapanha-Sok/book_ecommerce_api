package com.example.bookEcommerce.service.impl

import com.example.bookEcommerce.base.response.MessageResponse
import com.example.bookEcommerce.base.response.ObjectResponse
import com.example.bookEcommerce.base.response.PageResponse
import com.example.bookEcommerce.dto.AuthorDto
import com.example.bookEcommerce.dto.mapper.AuthorMapper
import com.example.bookEcommerce.exception.NotFoundException
import com.example.bookEcommerce.repository.AuthorRepository
import com.example.bookEcommerce.service.AuthorService
import jakarta.persistence.criteria.Predicate
import org.springframework.data.domain.PageRequest
import org.springframework.stereotype.Service

@Service
class AuthorServiceImpl(
    private val authorRepository: AuthorRepository,
    private val authorMapper: AuthorMapper) : AuthorService {
    override fun index(name: String?, page: Int, size: Int): PageResponse<AuthorDto?> {
        val authors = authorRepository.findAll(
            { root, query, builder ->
                val predicates = ArrayList<Predicate>()
                name?.let {
                    predicates.add(builder.like(builder.lower(root.get("name")), "%${it.lowercase()}%"))
                }
                query.orderBy(builder.desc(root.get<Long>("id")))
                builder.and(*predicates.toTypedArray())
            },PageRequest.of(page , size)
        )
        return PageResponse(authors.totalElements , authors.content.map { authorMapper.toDto(it) })
    }

    override fun show(id: Long): ObjectResponse<AuthorDto> {
        val author = authorRepository.findById(id)!!.orElseThrow { NotFoundException("Author not found with id $id") }
        return ObjectResponse(authorMapper.toDto(author))
    }

    override fun deleteById(id: Long): MessageResponse {
        val author = authorRepository.findById(id)!!.orElseThrow { NotFoundException("Author not found with id $id") }
        authorRepository.delete(author).let { return MessageResponse() }
    }

    override fun create(newAuthor: AuthorDto): MessageResponse {
        authorRepository.save(authorMapper.toModel(newAuthor)).let { return MessageResponse() }
    }

    override fun updateById(id: Long, updatedAuthor: AuthorDto): MessageResponse {
        TODO("Not yet implemented")
    }

}