package com.examen.zeuz.infrastructure.adapter.controller.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class WorkedHoursSummaryResponseDTO {
    private Integer totalWorkedHours;
    private boolean success;
}
