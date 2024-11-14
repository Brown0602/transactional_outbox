package com.tuaev.delivery_service.mapper;

import com.tuaev.delivery_service.document.Status;
import com.tuaev.delivery_service.dto.StatusDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import java.time.LocalDateTime;

@Mapper(componentModel = "spring")
public interface StatusMapper {

    @Mapping(source = "orderId", target = "orderId")
    @Mapping(source = "comments", target = "description")
    @Mapping(source = "localDateTime", target = "dateTime")
    Status toStatus(Long orderId, String comments, LocalDateTime localDateTime);

    @Mapping(source = "status.orderId", target = "orderId")
    @Mapping(source = "status.description", target = "description")
    @Mapping(source = "status.dateTime", target = "dateTime")
    StatusDTO toStatusDTO(Status status);
}
