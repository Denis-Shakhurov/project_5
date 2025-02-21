package org.example.dto.order;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import org.example.model.OrderStatus;

import java.time.LocalDate;

@Getter
public class OrderCreateDTO {
    @NotNull
    private OrderStatus status;

    @NotNull
    private LocalDate orderDate;

    @NotNull
    private Double price;
}
