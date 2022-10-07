package com.taeheon.calendar.common.dto;

import lombok.Getter;
import org.springframework.http.HttpMethod;

import javax.servlet.http.HttpServletRequest;

@Getter
public class ApiErrorResponse {
    private final int statusCode;
    private final String message;
    private final String error;
    private final String path;
    private final HttpMethod method;

    public ApiErrorResponse(int statusCode, String message, String error, HttpServletRequest request) {
        this.statusCode = statusCode;
        this.message = message;
        this.error = error;
        this.path = request.getRequestURI();
        this.method = HttpMethod.valueOf(request.getMethod());
    }

}
