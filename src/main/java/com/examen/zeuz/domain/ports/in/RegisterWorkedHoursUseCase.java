package com.examen.zeuz.domain.ports.in;

import com.examen.zeuz.domain.model.WorkedHoursModel;

public interface RegisterWorkedHoursUseCase {
    Integer register(WorkedHoursModel workedHours);
}
