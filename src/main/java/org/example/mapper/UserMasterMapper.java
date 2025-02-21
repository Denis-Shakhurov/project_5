package org.example.mapper;

import org.example.dto.usermaster.UserMasterCreateDTO;
import org.example.dto.usermaster.UserMasterDTO;
import org.example.dto.usermaster.UserMasterUpdateDTO;
import org.example.model.UserMaster;
import org.mapstruct.*;

@Mapper(
        uses = { JsonNullableMapper.class, ReferenceMapper.class},
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE,
        componentModel = MappingConstants.ComponentModel.SPRING,
        unmappedTargetPolicy = ReportingPolicy.IGNORE
)
public abstract class UserMasterMapper {
    public abstract UserMaster map(UserMasterDTO dto);

    public abstract UserMasterDTO map(UserMaster model);

    public abstract UserMaster map(UserMasterCreateDTO dto);

    public abstract void update(UserMasterUpdateDTO dto, @MappingTarget UserMaster model);
}
