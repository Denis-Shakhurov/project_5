package org.example.dto.usermaster;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;

import java.time.LocalDate;

@Getter
public class UserMasterDTO {
    private Long id;

    private String firstName;

    private String lastName;

    private String email;

    private String password;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy - MM - dd")
    private LocalDate createdAt;

}
