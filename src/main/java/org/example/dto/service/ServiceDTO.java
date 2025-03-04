package org.example.dto.service;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class ServiceDTO {
    private Long id;

    private String name;

    private String description;

    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private double price;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy - MM - dd")
    private LocalDate createAt;
}
