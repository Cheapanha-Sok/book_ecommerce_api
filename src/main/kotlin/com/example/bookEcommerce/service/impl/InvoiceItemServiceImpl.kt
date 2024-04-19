package com.example.bookEcommerce.service.impl;


import com.example.bookEcommerce.model.Book
import com.example.bookEcommerce.model.Invoice
import com.example.bookEcommerce.model.InvoiceItem
import com.example.bookEcommerce.repository.InvoiceItemRepository
import com.example.bookEcommerce.service.InvoiceItemService
import org.springframework.stereotype.Service;

@Service
class InvoiceItemServiceImpl(private val invoiceItemRepository: InvoiceItemRepository) : InvoiceItemService {
    override fun create(books: List<Book>, invoice: Invoice) {
        val invoiceItems :ArrayList<InvoiceItem> = ArrayList()
        books.map {
            val invoiceItem = InvoiceItem()
            invoiceItem.invoice = invoice
            invoiceItem.book = it
            invoiceItem.unitPrice = it.price!!
            invoiceItems.add(invoiceItem)
        }
        invoiceItemRepository.saveAll(invoiceItems)
    }
}
