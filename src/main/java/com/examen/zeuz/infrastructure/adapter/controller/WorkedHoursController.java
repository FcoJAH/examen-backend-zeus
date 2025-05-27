package com.examen.zeuz.infrastructure.adapter.controller;

import com.examen.zeuz.domain.model.WorkedHoursModel;
import com.examen.zeuz.domain.ports.in.GetWorkedHoursSummaryUseCase;
import com.examen.zeuz.domain.ports.in.RegisterWorkedHoursUseCase;
import com.examen.zeuz.infrastructure.adapter.controller.dto.WorkedHoursRequestDTO;
import com.examen.zeuz.infrastructure.adapter.controller.dto.WorkedHoursResponseDTO;
import com.examen.zeuz.infrastructure.adapter.controller.dto.WorkedHoursSummaryRequestDTO;
import com.examen.zeuz.infrastructure.adapter.controller.dto.WorkedHoursSummaryResponseDTO;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/horas-trabajadas")
public class WorkedHoursController {
    @Autowired
    private RegisterWorkedHoursUseCase useCase;

    @PostMapping
    public WorkedHoursResponseDTO registrarHoras(@Valid @RequestBody WorkedHoursRequestDTO request) {
        WorkedHoursModel wh = new WorkedHoursModel(null, request.getEmployeeId(), request.getWorkedHours(), request.getWorkedDate());
        Integer id = useCase.register(wh);
        return new WorkedHoursResponseDTO(id, id != null);
    }

    @Autowired
    private GetWorkedHoursSummaryUseCase useCaseSummary;

    @PostMapping("/resumen")
    public WorkedHoursSummaryResponseDTO getTotalWorkedHours(@Valid @RequestBody WorkedHoursSummaryRequestDTO request) {
        var result = useCaseSummary.getWorkedHours(request.getEmployeeId(), request.getStartDate(), request.getEndDate());
        return new WorkedHoursSummaryResponseDTO(result.getTotalWorkedHours(), result.isSuccess());
    }
}
