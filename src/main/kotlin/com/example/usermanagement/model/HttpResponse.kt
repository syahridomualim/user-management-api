package com.example.usermanagement.model

import org.springframework.http.HttpStatus
import java.time.LocalDateTime

data class HttpResponse(
    val time: LocalDateTime,
    val statusCode: Int,
    val httpStatus: HttpStatus,
    val reason: String,
    val message: String,
    val data: Map<*, *>
)