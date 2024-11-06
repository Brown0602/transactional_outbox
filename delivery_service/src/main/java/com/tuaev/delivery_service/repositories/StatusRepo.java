package com.tuaev.delivery_service.repositories;

import com.tuaev.delivery_service.document.Status;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StatusRepo extends MongoRepository<Status, Long> {
    Status findByOrderId(Long orderId);
}
