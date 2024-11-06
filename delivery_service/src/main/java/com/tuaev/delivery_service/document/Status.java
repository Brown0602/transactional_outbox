package com.tuaev.delivery_service.document;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.time.LocalDateTime;

@Document(collection = "orders")
@Getter
@Setter
public class Status{

    public Status(Long orderId, String status, LocalDateTime dateTime) {
        this.orderId = orderId;
        this.comments = status;
        this.dateTime = dateTime;
    }

    public Status() {
    }

    @Id
    private String id;
    @Field("order_id")
    private Long orderId;
    @Field("status")
    private String comments;
    @Field("datetime")
    private LocalDateTime dateTime;
}
