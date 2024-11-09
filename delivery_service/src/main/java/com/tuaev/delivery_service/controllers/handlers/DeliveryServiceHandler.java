package com.tuaev.delivery_service.controllers.handlers;

import com.tuaev.delivery_service.error.DefaultErrorResponse;
import com.tuaev.delivery_service.exceptions.DeliveryRequestFailedException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import java.time.LocalDateTime;

@ControllerAdvice
public class DeliveryServiceHandler {

    @ExceptionHandler(DeliveryRequestFailedException.class)
    @ResponseStatus(HttpStatus.TOO_MANY_REQUESTS)
    @ResponseBody
    public DefaultErrorResponse defaultErrorResponse(DeliveryRequestFailedException exception){
        return new DefaultErrorResponse(
                exception.getMessage(),
                HttpStatus.TOO_MANY_REQUESTS.value(),
                LocalDateTime.now()
        );
    }
}
