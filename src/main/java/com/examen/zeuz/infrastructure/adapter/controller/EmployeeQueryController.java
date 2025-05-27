package com.examen.zeuz.infrastructure.adapter.controller;

import com.examen.zeuz.domain.ports.in.GetEmployeesByJobUseCase;
import com.examen.zeuz.infrastructure.adapter.controller.dto.GetEmployeesByJobRequestDTO;
import com.examen.zeuz.infrastructure.adapter.controller.dto.GetEmployeesByJobResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/buscar-empleados")
public class EmployeeQueryController {
    @Autowired
    private GetEmployeesByJobUseCase useCase;

    @PostMapping("/por-puesto")
    public GetEmployeesByJobResponseDTO getByJob(@RequestBody GetEmployeesByJobRequestDTO request) {
        var employees = useCase.getEmployeesByJobId(request.getJobId());
        return new GetEmployeesByJobResponseDTO(employees, employees != null);
    }
}
