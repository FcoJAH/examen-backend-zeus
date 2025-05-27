package com.examen.zeuz.domain.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDate;

@Data
@AllArgsConstructor
public class WorkedHoursModel {
    private Integer id;
    private Integer employeeId;
    private Integer workedHours;
    private LocalDate workedDate;
}
