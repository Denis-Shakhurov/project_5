package org.example.dto.order;

import lombok.Getter;
import org.example.model.OrderStatus;
import org.openapitools.jackson.nullable.JsonNullable;

import java.time.LocalDate;

@Getter
public class OrderUpdateDTO {
    private JsonNullable<OrderStatus> status;

    private JsonNullable<LocalDate> orderDate;

    private JsonNullable<Double> price;
}
