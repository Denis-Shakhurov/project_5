package org.example.mapper;

import org.example.dto.typeservice.TypeServiceCreateDTO;
import org.example.dto.typeservice.TypeServiceDTO;
import org.example.dto.typeservice.TypeServiceUpdateDTO;
import org.example.model.TypeService;
import org.mapstruct.*;

@Mapper(
        uses = { JsonNullableMapper.class, ReferenceMapper.class},
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE,
        componentModel = MappingConstants.ComponentModel.SPRING,
        unmappedTargetPolicy = ReportingPolicy.IGNORE
)
public abstract class TypeServiceMapper {

    public abstract TypeService map(TypeServiceDTO dto);

    public abstract TypeServiceDTO map(TypeService model);

    public abstract TypeService map(TypeServiceCreateDTO dto);

    public abstract void update(TypeServiceUpdateDTO dto, @MappingTarget TypeService model);
}
