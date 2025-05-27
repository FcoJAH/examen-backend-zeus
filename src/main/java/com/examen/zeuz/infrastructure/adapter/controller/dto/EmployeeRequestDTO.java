package com.examen.zeuz.infrastructure.adapter.controller.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.time.LocalDate;

@Data
public class EmployeeRequestDTO {
    @NotBlank
    private String name;

    @NotBlank
    private String lastName;

    @NotBlank
    private LocalDate birthdate;

    @NotBlank
    private Integer genderId;

    @NotNull
    private Integer jobId;
}
