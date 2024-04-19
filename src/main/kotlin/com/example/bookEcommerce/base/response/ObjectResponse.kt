package com.example.bookEcommerce.base.response;

import org.springframework.stereotype.Component

@Component
class ObjectResponse<T>(
    var result :T ? =null,
    var response : ResponseMessage? = ResponseMessage().response()
)