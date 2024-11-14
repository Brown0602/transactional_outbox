package com.tuaev.order_service.mapper;

import com.tuaev.order_service.dto.OrderDTO;
import com.tuaev.order_service.entity.Order;
import com.tuaev.order_service.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import java.time.LocalDateTime;

@Mapper(componentModel = "spring")
public interface OrderMapper {

    @Mapping(source = "orderDTO.address", target = "address")
    @Mapping(source = "orderDTO.paymentMethod", target = "paymentMethod")
    @Mapping(source = "orderDTO.comments", target = "comments")
    @Mapping(source = "orderDTO.userEmail", target = "userEmail")
    @Mapping(source = "user", target = "user")
    @Mapping(source = "localDateTime", target = "dateTime")
    Order toOrder(OrderDTO orderDTO, User user, LocalDateTime localDateTime);

    @Mapping(source = "order.address", target = "address")
    @Mapping(source = "order.paymentMethod", target = "paymentMethod")
    @Mapping(source = "order.comments", target = "comments")
    @Mapping(source = "order.userEmail", target = "userEmail")
    @Mapping(source = "order.user", target = "userDTO")
    @Mapping(source = "order.dateTime", target = "dateTime")
    OrderDTO toOrderDTO(Order order);
}
