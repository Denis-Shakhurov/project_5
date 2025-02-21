package org.example.dto.user;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import org.openapitools.jackson.nullable.JsonNullable;

@Getter
public class UserUpdateDTO {
    private JsonNullable<String> firstName;

    private JsonNullable<String> lastName;

    @NotNull
    @Email
    @NotBlank
    private JsonNullable<String> email;

    @NotNull
    private JsonNullable<String> password;
}