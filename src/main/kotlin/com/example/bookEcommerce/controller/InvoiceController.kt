package com.example.bookEcommerce.controller

import com.example.bookEcommerce.base.response.ObjectResponse
import com.example.bookEcommerce.dto.InvoiceDto
import com.example.bookEcommerce.projection.InvoiceProjection
import com.example.bookEcommerce.service.InvoiceService
import com.example.bookEcommerce.utils.anotation.Sl4JLogger
import com.example.bookEcommerce.utils.constants.Constants
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController



@RestController
@Sl4JLogger
@RequestMapping("${Constants.MAIN_URL}invoice")
class InvoiceController(
    private val invoiceService: InvoiceService
) {

    @GetMapping
    fun index() : ObjectResponse<List<InvoiceDto>>{

        return invoiceService.index()
    }
    @GetMapping("/projection")
    fun findByProjection(): ObjectResponse<List<InvoiceProjection>>{
        return invoiceService.findByProjection()
    }
}