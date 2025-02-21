package org.example.mapper;

import lombok.RequiredArgsConstructor;
import org.example.dto.user.UserCreateDTO;
import org.example.dto.user.UserDTO;
import org.example.dto.user.UserUpdateDTO;
import org.example.model.User;
import org.mapstruct.*;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Mapper(
        uses = { JsonNullableMapper.class, ReferenceMapper.class},
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE,
        componentModel = MappingConstants.ComponentModel.SPRING,
        unmappedTargetPolicy = ReportingPolicy.IGNORE
)
@RequiredArgsConstructor
public abstract class UserMapper {
    private final BCryptPasswordEncoder passwordEncoder;

    public abstract UserDTO map(User model);

    public abstract User map(UserDTO dto);

    public abstract User map(UserCreateDTO dto);

    public abstract void update(UserUpdateDTO dto, @MappingTarget User model);

    @BeforeMapping
    private void encryptPassword(UserCreateDTO dto) {
        String password = dto.getPassword();
        dto.setPassword(passwordEncoder.encode(password));
    }

    @BeforeMapping
    private void encryptPassword(UserUpdateDTO dto, @MappingTarget User model) {
        if (dto.getPassword() != null && dto.getPassword().isPresent()) {
            String password = dto.getPassword().get();
            model.setPassword(passwordEncoder.encode(password));
        }
    }
}
