package org.example.mapper;

import org.example.dto.order.OrderCreateDTO;
import org.example.dto.order.OrderDTO;
import org.example.dto.order.OrderUpdateDTO;
import org.example.model.Order;
import org.mapstruct.*;

@Mapper(
        uses = { JsonNullableMapper.class, ReferenceMapper.class},
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE,
        componentModel = MappingConstants.ComponentModel.SPRING,
        unmappedTargetPolicy = ReportingPolicy.IGNORE
)
public abstract class OrderMapper {

    public abstract Order map(OrderDTO dto);

    public abstract OrderDTO map(Order model);

    public abstract Order map(OrderCreateDTO dto);

    public abstract void update(OrderUpdateDTO dto, @MappingTarget Order model);
}
