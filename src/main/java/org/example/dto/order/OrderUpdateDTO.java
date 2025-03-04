package org.example.dto.order;

import lombok.Getter;
import lombok.Setter;
import org.example.model.OrderStatus;
import org.openapitools.jackson.nullable.JsonNullable;

import java.time.LocalDateTime;

@Getter
@Setter
public class OrderUpdateDTO {
    private JsonNullable<OrderStatus> status;

    private JsonNullable<LocalDateTime> orderDate;

    private JsonNullable<Double> price;
}
