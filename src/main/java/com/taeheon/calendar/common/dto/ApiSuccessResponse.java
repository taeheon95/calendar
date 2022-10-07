package com.taeheon.calendar.common.dto;

import lombok.Getter;

@Getter
public class ApiSuccessResponse<T> {
    private final int statusCode;
    private final String message;
    private final T data;

    private ApiSuccessResponse(int code, String message, T data) {
        this.statusCode = code;
        this.message = message;
        this.data = data;
    }

    public static <T> ApiSuccessResponse<T> ok(T data) {
        return new ApiSuccessResponse<>(200, "success", data);
    }

    public static <T> ApiSuccessResponse<T> created(T data) {
        return new ApiSuccessResponse<>(201, "created", data);
    }

    public static <T> ApiSuccessResponse<T> noContent() {
        return new ApiSuccessResponse<>(204, "no content", null);
    }
}
