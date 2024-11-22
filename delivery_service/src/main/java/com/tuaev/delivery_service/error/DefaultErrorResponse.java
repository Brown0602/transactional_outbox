package com.tuaev.delivery_service.error;

import java.time.LocalDateTime;

public class DefaultErrorResponse {

    private String message;
    private int code;
    private LocalDateTime dateTime;

    public DefaultErrorResponse(String message, int code, LocalDateTime dateTime) {
        this.message = message;
        this.code = code;
        this.dateTime = dateTime;
    }

    public String getMessage() {
        return message;
    }

    public int getCode() {
        return code;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }
}
