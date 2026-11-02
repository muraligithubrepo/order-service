package org.order.service.domain;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class OrderDTO {

    @NotNull(message = "Order ID cannot be null")
    private Long orderId;

    @NotBlank(message = "User ID cannot be null or empty")
    private String userId;

    @NotBlank(message = "Product ID cannot be null or empty")
    private String productId;

    @NotNull(message = "Quantity cannot be null")
    @Positive(message = "Quantity must be greater than zero")
    private Integer quantity;

    @NotNull(message = "Total price cannot be null")
    @Positive(message = "Total price must be greater than zero")
    private Double totalPrice;

    @NotBlank(message = "Order status cannot be null or empty")
    private String orderStatus;

}
