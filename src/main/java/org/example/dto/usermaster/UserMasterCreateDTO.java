package org.example.dto.usermaster;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserMasterCreateDTO {
    private String firstName;

    private String lastName;

    @Email
    @NotBlank
    @NotNull
    private String email;

    @NotNull
    private String password;
}
