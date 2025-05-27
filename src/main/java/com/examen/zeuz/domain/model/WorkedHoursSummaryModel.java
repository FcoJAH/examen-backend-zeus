package com.examen.zeuz.domain.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class WorkedHoursSummaryModel {
    private Integer totalWorkedHours;
    private boolean success;
}
