package com.tectonic.acaro.api.exception

import com.tectonic.acaro.domain.exception.ResourceAlreadyExistsException
import com.tectonic.acaro.domain.exception.BadRequestException
import com.tectonic.acaro.domain.exception.ResourceNotFoundException
import com.tectonic.acaro.domain.exception.UnprocessableEntityException
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler

@ControllerAdvice
class RestApiExceptionHandler : ResponseEntityExceptionHandler() {

    @ExceptionHandler(ResourceAlreadyExistsException::class)
    fun handleResourceAlreadyExistsException(ex: ResourceAlreadyExistsException): ResponseEntity<Any> {
        return ErrorResponse(HttpStatus.UNPROCESSABLE_ENTITY.value(), HttpStatus.UNPROCESSABLE_ENTITY, ex.message)
            .let { ResponseEntity(it, it.error) }
    }

    @ExceptionHandler(BadRequestException::class)
    fun handleResourceBadRequestException(ex: BadRequestException): ResponseEntity<Any> {
        return ErrorResponse(HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST, ex.message)
            .let { ResponseEntity(it, it.error) }
    }

    @ExceptionHandler(ResourceNotFoundException::class)
    fun handleResourceNotFoundException(ex: ResourceNotFoundException): ResponseEntity<Any> {
        return ErrorResponse(HttpStatus.NOT_FOUND.value(), HttpStatus.NOT_FOUND, ex.message)
            .let { ResponseEntity(it, it.error) }
    }

    @ExceptionHandler(UnprocessableEntityException::class)
    fun handleUnprocessableEntityException(ex: UnprocessableEntityException): ResponseEntity<Any> {
        return ErrorResponse(HttpStatus.UNPROCESSABLE_ENTITY.value(), HttpStatus.UNPROCESSABLE_ENTITY, ex.message)
            .let { ResponseEntity(it, it.error) }
    }
}
