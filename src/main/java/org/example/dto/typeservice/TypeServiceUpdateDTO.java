package org.example.dto.typeservice;

import lombok.Getter;
import lombok.Setter;
import org.openapitools.jackson.nullable.JsonNullable;

@Getter
@Setter
public class TypeServiceUpdateDTO {

    private JsonNullable<String> name;
}
