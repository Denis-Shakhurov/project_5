package org.example.mapper;

import org.example.dto.service.ServiceCreateDTO;
import org.example.dto.service.ServiceDTO;
import org.example.dto.service.ServiceUpdateDTO;
import org.example.model.ServiceUser;
import org.mapstruct.*;

@Mapper(
        uses = { JsonNullableMapper.class, ReferenceMapper.class},
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE,
        componentModel = MappingConstants.ComponentModel.SPRING,
        unmappedTargetPolicy = ReportingPolicy.IGNORE
)
public abstract class ServiceUserMapper {

    public abstract ServiceUser map(ServiceDTO dto);

    public abstract ServiceDTO map(ServiceUser model);

    public abstract ServiceUser map(ServiceCreateDTO dto);

    public abstract void update(ServiceUpdateDTO dto, @MappingTarget ServiceUser model);
}
