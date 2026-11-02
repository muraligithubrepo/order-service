package org.order.service.service;

import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.order.service.config.OrderMapper;
import org.order.service.domain.OrderDTO;
import org.order.service.domain.ResponseDTO;
import org.order.service.entity.Order;
import org.order.service.repo.OrderServiceRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OrderService {
    private final OrderServiceRepo orderServiceRepo;
    private final ModelMapper modelMapper;
    private final OrderMapper orderMapper;

    public ResponseDTO createOrder(OrderDTO orderDTO) {

        /*Order order = Order.builder()
                .userId(orderDTO.getUserId())
                .productId(orderDTO.getProductId())
                .quantity(orderDTO.getQuantity())
                .totalPrice(orderDTO.getTotalPrice())
                .orderStatus("CREATED")
                .build();*/

        //TODO:  use library like model mapper to map orderDTO to Order entity and vice versa instead of manually mapping the fields

        // DTO to Entity using ModelMapper
        Order order = modelMapper.map(orderDTO, Order.class);

        Order orderCreated = orderServiceRepo.save ( order );

         // Entity to DTO using ModelMapper
         // modelMapper.map(orderCreated, OrderDTO.class);


        /*OrderDTO response = OrderDTO.builder()
                .userId(orderCreated.getUserId())
                .productId(orderCreated.getProductId())
                .quantity(orderCreated.getQuantity())
                .totalPrice(orderCreated.getTotalPrice())
                .orderStatus(orderCreated.getOrderStatus ())
                .build();*/

        //TODO: convert using map struct to convert order to orderDTO and vice versa instead of manually mapping the fields
        // You can use MapStruct to convert Order Entity into OrderDTO automatically.
        // Unlike ModelMapper, MapStruct generates mapping code at compile time.

        // Entity to DTO using MapStruct
        OrderDTO response = orderMapper.toOrderDTO(orderCreated);

        return ResponseDTO.builder()
                .message("Order created successfully")
                .data(response)
                .build();
    }
}
