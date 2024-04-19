package com.example.bookEcommerce.service.impl

import com.example.bookEcommerce.dto.mapper.InvoiceMapper
import com.example.bookEcommerce.base.response.ObjectResponse
import com.example.bookEcommerce.dto.InvoiceDto
import com.example.bookEcommerce.model.Book
import com.example.bookEcommerce.model.Invoice
import com.example.bookEcommerce.model.User
import com.example.bookEcommerce.projection.InvoiceProjection
import com.example.bookEcommerce.repository.InvoiceRepository
import com.example.bookEcommerce.service.InvoiceItemService
import com.example.bookEcommerce.service.InvoiceService
import org.springframework.stereotype.Service


@Service
class InvoiceServiceImpl(
    private val invoiceRepository: InvoiceRepository,
    private val invoiceItemService: InvoiceItemService,
    private val invoiceMapper: InvoiceMapper,

    ) : InvoiceService {
    override fun findByProjection(): ObjectResponse<List<InvoiceProjection>> {
        invoiceRepository.findAllInvoiceBy().let { return ObjectResponse(it) }
    }

    override fun create(books: List<Book>, totalPrice: Double, totalBook: Int, user: User) {
        val existingInvoice = existUser(user)
        val invoice : Invoice = existingInvoice.orElseGet { Invoice(totalPrice = totalPrice, totalBook = totalBook, user = user) }
        val savedInvoice = invoiceRepository.save(invoice)
        invoiceItemService.create(books, savedInvoice)
    }

    override fun index(): ObjectResponse<List<InvoiceDto>> {
        return ObjectResponse(invoiceRepository.findAll()!!.map { invoiceMapper.toDto(it) })
    }

    private fun existUser(user: User) = invoiceRepository.findInvoiceByUser(user)
}