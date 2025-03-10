package org.example.dto.service;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import org.openapitools.jackson.nullable.JsonNullable;

@Getter
@Setter
public class ServiceUpdateDTO {
    @NotNull
    private JsonNullable<String> name;

    @NotNull
    private JsonNullable<String> description;

    @NotNull
    private JsonNullable<Double> price;
}
