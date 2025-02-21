package org.example.dto.typeservice;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;

@Getter
public class TypeServiceCreateDTO {

    @NotNull
    private String name;
}
