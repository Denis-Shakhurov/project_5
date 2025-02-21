package org.example.mapper;

import lombok.RequiredArgsConstructor;
import org.example.dto.usermaster.UserMasterCreateDTO;
import org.example.dto.usermaster.UserMasterDTO;
import org.example.dto.usermaster.UserMasterUpdateDTO;
import org.example.model.UserMaster;
import org.mapstruct.*;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Mapper(
        uses = { JsonNullableMapper.class, ReferenceMapper.class},
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE,
        componentModel = MappingConstants.ComponentModel.SPRING,
        unmappedTargetPolicy = ReportingPolicy.IGNORE
)
@RequiredArgsConstructor
public abstract class UserMasterMapper {
    private final BCryptPasswordEncoder passwordEncoder;

    public abstract UserMaster map(UserMasterDTO dto);

    public abstract UserMasterDTO map(UserMaster model);

    public abstract UserMaster map(UserMasterCreateDTO dto);

    public abstract void update(UserMasterUpdateDTO dto, @MappingTarget UserMaster model);

    @BeforeMapping
    private void encryptPassword(UserMasterCreateDTO dto) {
        String password = dto.getPassword();
        dto.setPassword(passwordEncoder.encode(password));
    }

    @BeforeMapping
    private void encryptPassword(UserMasterUpdateDTO dto, @MappingTarget UserMaster model) {
        if (dto.getPassword() != null && dto.getPassword().isPresent()) {
            String password = dto.getPassword().get();
            model.setPassword(passwordEncoder.encode(password));
        }
    }
}
