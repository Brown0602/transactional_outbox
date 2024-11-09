package com.tuaev.delivery_service.exceptions;

public class DeliveryRequestFailedException extends RuntimeException{

    public DeliveryRequestFailedException(String message) {
        super(message);
    }

    public DeliveryRequestFailedException() {
        super();
    }
}
