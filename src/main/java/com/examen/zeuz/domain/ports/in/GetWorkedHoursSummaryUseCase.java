package com.examen.zeuz.domain.ports.in;

import com.examen.zeuz.domain.model.WorkedHoursSummaryModel;

import java.time.LocalDate;

public interface GetWorkedHoursSummaryUseCase {
    WorkedHoursSummaryModel getWorkedHours(Integer employeeId, LocalDate startDate, LocalDate endDate);
}
