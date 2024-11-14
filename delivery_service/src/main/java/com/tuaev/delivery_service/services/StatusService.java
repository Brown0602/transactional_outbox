package com.tuaev.delivery_service.services;

import com.tuaev.delivery_service.document.Status;
import com.tuaev.delivery_service.dto.StatusDTO;

public interface StatusService {

    StatusDTO save(Long orderId);

    Status update(Long orderId, String comments);
}
