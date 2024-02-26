package com.tectonic.acaro.feign.util

import com.tectonic.acaro.domain.exception.ResourceAlreadyExistsException
import com.tectonic.acaro.domain.exception.BadRequestException
import com.tectonic.acaro.domain.exception.ResourceNotFoundException
import feign.FeignException
import org.springframework.http.HttpStatus

class HandleFeignExceptionUtil() {

    companion object {
        fun handleFeignException(exception: Throwable) {
            if (exception is FeignException) {
                when (HttpStatus.valueOf(exception.status())) {
                    HttpStatus.BAD_REQUEST -> throw BadRequestException(exception.message ?: "Bad Request Exception")
                    HttpStatus.NOT_FOUND -> throw ResourceNotFoundException(exception.message ?: "Resource Not Found Exception")
                    HttpStatus.CONFLICT -> throw ResourceAlreadyExistsException(exception.message ?: "Request Conflict Exception")
                    else -> throw exception
                }
            }
            throw exception
        }
    }
}
