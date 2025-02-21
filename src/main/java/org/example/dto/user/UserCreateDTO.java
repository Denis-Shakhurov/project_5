package org.example.dto.user;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;

@Getter
public class UserCreateDTO {
    private String firstName;

    private String lastName;

    @Email
    @NotBlank
    @NotNull
    private String email;

    @NotNull
    private String password;
}
