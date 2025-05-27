package com.examen.zeuz.domain.ports.out;

import com.examen.zeuz.domain.model.WorkedHoursModel;

public interface WorkedHoursRepository {
    boolean employeeExists(int employeeId);
    boolean workedDateExists(int employeeId, java.time.LocalDate workedDate);
    Integer save(WorkedHoursModel workedHours);
}
