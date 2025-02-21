package org.example.mapper;

import org.example.dto.user.UserCreateDTO;
import org.example.dto.user.UserDTO;
import org.example.dto.user.UserUpdateDTO;
import org.example.model.User;
import org.mapstruct.*;

@Mapper(
        uses = { JsonNullableMapper.class, ReferenceMapper.class},
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE,
        componentModel = MappingConstants.ComponentModel.SPRING,
        unmappedTargetPolicy = ReportingPolicy.IGNORE
)
public abstract class UserMapper {
    public abstract UserDTO map(User model);

    public abstract User map(UserDTO dto);

    public abstract User map(UserCreateDTO dto);

    public abstract void update(UserUpdateDTO dto, @MappingTarget User model);
}
