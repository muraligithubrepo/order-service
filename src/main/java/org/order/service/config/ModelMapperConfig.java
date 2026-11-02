package org.order.service.config;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeMap;
import org.order.service.domain.OrderDTO;
import org.order.service.entity.Order;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ModelMapperConfig {

    @Bean
    public ModelMapper modelMapper() {

        ModelMapper modelMapper = new ModelMapper();
        TypeMap<OrderDTO, Order> typeMap =
                modelMapper.createTypeMap(OrderDTO.class, Order.class);

        typeMap.addMapping(
                OrderDTO::getOrderId,
                Order::setOrderId
        );

        typeMap.addMapping(
                OrderDTO::getUserId,
                Order::setUserId
        );

        typeMap.addMapping(
                OrderDTO::getProductId,
                Order::setProductId
        );

        typeMap.addMapping(
                OrderDTO::getQuantity,
                Order::setQuantity
        );

        typeMap.addMapping(
                OrderDTO::getTotalPrice,
                Order::setTotalPrice
        );

        typeMap.addMapping(
                OrderDTO::getOrderStatus,
                Order::setOrderStatus
        );

        return new ModelMapper();
    }
}
