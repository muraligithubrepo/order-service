package org.order.service.config;

import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.order.service.domain.OrderDTO;
import org.order.service.entity.Order;


@Mapper(componentModel = "spring")
public interface OrderMapper {

    @BeanMapping(ignoreByDefault = true)
    @Mapping(source = "orderId", target = "orderId")
    @Mapping(source = "userId", target = "userId")
    @Mapping(source = "productId", target = "productId")
    @Mapping(source = "quantity", target = "quantity")
    @Mapping(source = "totalPrice", target = "totalPrice")
    @Mapping(source = "orderStatus", target = "orderStatus")
    OrderDTO toOrderDTO(Order order);

    Order toOrder(OrderDTO orderDTO);

}
