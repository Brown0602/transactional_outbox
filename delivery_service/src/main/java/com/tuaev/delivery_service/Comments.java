package com.tuaev.delivery_service;

import java.util.List;

public enum Comments {

    GENERATED("Создан"), TAKEN("В работе"), EXPECTATION("Ожидание курьера"), COURIER("У курьера"), DELIVERED("Доставлен");

    private final String status;

    Comments(String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }

    public static List<String> getAllStatuses(){
        return List.of(
                Comments.GENERATED.getStatus(),
                Comments.TAKEN.getStatus(),
                Comments.EXPECTATION.getStatus(),
                Comments.COURIER.getStatus(),
                Comments.DELIVERED.getStatus()
        );
    }
}
