package com.examen.zeuz.infrastructure.adapter.controller.dto;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.time.LocalDate;

@Data
public class WorkedHoursRequestDTO {
    @NotNull
    private Integer employeeId;

    @NotNull
    @Min(1)
    @Max(20)
    private Integer workedHours;

    @NotNull
    private LocalDate workedDate;
}
