package com.tectonic.acaro.api.exception

import com.fasterxml.jackson.annotation.JsonFormat
import org.springframework.http.HttpStatus
import java.time.LocalDateTime

class ErrorResponse(
    val status: Int? = null,
    val error: HttpStatus = HttpStatus.INTERNAL_SERVER_ERROR,
    val message: String? = null,
) {

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    private val timestamp: LocalDateTime = LocalDateTime.now()
}
