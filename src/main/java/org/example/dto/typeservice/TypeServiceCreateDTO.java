package org.example.dto.typeservice;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TypeServiceCreateDTO {

    @NotNull
    private String name;
}
