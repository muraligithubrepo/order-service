package org.order.service.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.order.service.domain.OrderDTO;
import org.order.service.domain.ResponseDTO;
import org.order.service.service.OrderService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
public class OrderController {

    private final OrderService orderService;

    @PostMapping("/order")
    public ResponseEntity<ResponseDTO> createOrder(@Valid @RequestBody OrderDTO orderDTO) {
        log.info("OrderController: createOrder called");
        ResponseDTO responseDTO= orderService.createOrder(orderDTO);
        return ResponseEntity.ok(responseDTO);
    }


}
