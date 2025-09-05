package com.taeheon.api.calendar.common

class ApiResponse<T>(
    val code: String,
    val message: String,
    val data: T
)