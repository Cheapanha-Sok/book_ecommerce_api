package com.example.bookEcommerce.dto.mapper

import com.example.bookEcommerce.dto.InvoiceDto
import com.example.bookEcommerce.model.Invoice
import org.mapstruct.Mapper

@Mapper
interface InvoiceMapper {
    fun toDto(invoice: Invoice): InvoiceDto
}
