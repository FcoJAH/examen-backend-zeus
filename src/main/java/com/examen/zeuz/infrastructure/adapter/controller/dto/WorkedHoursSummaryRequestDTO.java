package com.examen.zeuz.infrastructure.adapter.controller.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.time.LocalDate;

@Data
public class WorkedHoursSummaryRequestDTO {
    @NotNull
    private Integer employeeId;

    @NotNull
    private LocalDate startDate;

    @NotNull
    private LocalDate endDate;
}
