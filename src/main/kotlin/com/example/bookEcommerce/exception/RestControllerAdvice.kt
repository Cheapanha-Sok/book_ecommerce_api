package com.example.bookEcommerce.exception

import com.example.bookEcommerce.dto.NotFoundDto
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.validation.FieldError
import org.springframework.web.bind.MethodArgumentNotValidException
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.RestControllerAdvice
import java.time.LocalTime


@RestControllerAdvice
class RestControllerAdvice {

    @ExceptionHandler(MethodArgumentNotValidException::class)
    fun handleValidationExceptions(
        ex: MethodArgumentNotValidException
    ): ResponseEntity<Map<String, String?>> {
        val errors: HashMap<String, String?> = HashMap()
        ex.bindingResult.allErrors.forEach { error ->
            val fieldName = (error as FieldError).field
            val errorMessage = error.defaultMessage
            errors[fieldName] = errorMessage
        }
        return ResponseEntity(errors, HttpStatus.BAD_REQUEST)
    }

    @ExceptionHandler(NotFoundException::class)
    fun handleNotFoundException(ex: NotFoundException): ResponseEntity<NotFoundDto> {
        val errorMessage = NotFoundDto(
            HttpStatus.NOT_FOUND.value(),
            ex.message,
            localTime = LocalTime.now()
        )
        return ResponseEntity(errorMessage, HttpStatus.NOT_FOUND)
    }
}

