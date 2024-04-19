package com.example.bookEcommerce.dto.mapper.impl
import com.example.bookEcommerce.dto.InvoiceDto
import com.example.bookEcommerce.dto.mapper.InvoiceItemMapper
import com.example.bookEcommerce.dto.mapper.InvoiceMapper
import com.example.bookEcommerce.model.Invoice
import org.springframework.stereotype.Component

@Component
class InvoiceMapperImpl(private val invoiceItemMapper: InvoiceItemMapper) : InvoiceMapper {
    override fun toDto(invoice: Invoice): InvoiceDto {
        return InvoiceDto(
            id = invoice.id!!,
            userName = invoice.user?.firstName + invoice.user?.lastName,
            userId = invoice.user?.id!!,
            totalItem = invoice.invoiceItems!!.size,
            totalPrice = invoice.totalPrice,
            invoiceItems = invoice.invoiceItems!!.map { invoiceItemMapper.toDto(it) }
        )
    }
}
