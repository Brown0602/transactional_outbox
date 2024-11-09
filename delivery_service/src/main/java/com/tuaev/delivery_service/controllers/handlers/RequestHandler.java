package com.tuaev.delivery_service.controllers.handlers;

import com.tuaev.delivery_service.exceptions.DeliveryRequestFailedException;

public class RequestHandler{

    private static int requestCount;

    private RequestHandler(){}

    public static void requestLimit(){
        requestCount++;
        if (requestCount > 5 ){
            requestCount = 0;
            throw new DeliveryRequestFailedException("Превышено кол-во запросов к ресурсу");
        }
    }
}
