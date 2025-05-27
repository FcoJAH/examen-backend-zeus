package com.examen.zeuz.domain.ports.out;

import java.time.LocalDate;

public interface WorkedHoursSummaryRepository {
    boolean employeeExists(int employeeId);
    Integer getTotalWorkedHours(int employeeId, LocalDate startDate, LocalDate endDate);
}
