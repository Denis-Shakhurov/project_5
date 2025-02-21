package org.example.dto.order;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import org.example.model.OrderStatus;

import java.time.LocalDate;

@Getter
public class OrderDTO {
    private Long id;

    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private OrderStatus status;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy - MM - dd hh:mm")
    private LocalDate orderDate;

    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private double price;

    private Long userId;
}
