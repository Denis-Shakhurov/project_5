package org.example.dto.service;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;

@Getter
public class ServiceCreateDTO {
    @NotNull
    private String name;

    @NotNull
    private String description;

    @NotNull
    private Double price;
}
