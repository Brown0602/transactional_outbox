package com.tuaev.delivery_service.services;

import com.tuaev.delivery_service.document.Status;

public interface StatusService {

    Status save(Long orderId);

    Status update(Long orderID, String comments);
}
