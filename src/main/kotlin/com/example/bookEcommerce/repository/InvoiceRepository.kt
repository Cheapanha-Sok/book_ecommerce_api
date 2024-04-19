package com.example.bookEcommerce.repository

import com.example.bookEcommerce.base.repository.BaseRepository
import com.example.bookEcommerce.model.Invoice
import com.example.bookEcommerce.model.User
import com.example.bookEcommerce.projection.InvoiceProjection
import org.springframework.data.jpa.repository.Query
import org.springframework.stereotype.Repository
import java.util.Optional

@Repository
interface InvoiceRepository : BaseRepository<Invoice, Long> {
    fun findInvoiceByUser(user: User): Optional<Invoice>
    @Query("select invoice from Invoice invoice" +
            " join fetch invoice.invoiceItems " +
            "invoiceItem join fetch invoiceItem.book " +
            "book join fetch book.author " +
            "join fetch book.category" +
            " join fetch invoice.user user join fetch user.role")
    fun findAllInvoiceBy(): List<InvoiceProjection>

}
