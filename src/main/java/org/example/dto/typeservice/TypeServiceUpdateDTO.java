package org.example.dto.typeservice;

import lombok.Getter;
import org.openapitools.jackson.nullable.JsonNullable;

@Getter
public class TypeServiceUpdateDTO {

    private JsonNullable<String> name;
}
