package com.examen.zeuz.infrastructure.adapter.controller;

import com.examen.zeuz.domain.model.EmployeeModel;
import com.examen.zeuz.domain.ports.in.CreateEmployeeUseCase;
import com.examen.zeuz.domain.ports.in.GetEmployeesByJobUseCase;
import com.examen.zeuz.infrastructure.adapter.controller.dto.EmployeeRequestDTO;
import com.examen.zeuz.infrastructure.adapter.controller.dto.EmployeeResponseDTO;
import com.examen.zeuz.infrastructure.adapter.controller.dto.GetEmployeesByJobRequestDTO;
import com.examen.zeuz.infrastructure.adapter.controller.dto.GetEmployeesByJobResponseDTO;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/empleados")
public class EmployeeController {
    @Autowired
    private CreateEmployeeUseCase useCase;

    @PostMapping
    public EmployeeResponseDTO agregarEmpleado(@Valid @RequestBody EmployeeRequestDTO request){
        EmployeeModel employee = new EmployeeModel(
                null,
                request.getName(),
                request.getLastName(),
                request.getBirthdate(),
                request.getGenderId(),
                request.getJobId()
        );

        Integer id = useCase.createEmployee(employee);
        return new EmployeeResponseDTO(id, id != null);
    }

    @Autowired
    private GetEmployeesByJobUseCase useCasePuesto;

    @PostMapping("/buscar-puesto")
    public GetEmployeesByJobResponseDTO getByJob(@RequestBody GetEmployeesByJobRequestDTO request) {
        var employees = useCasePuesto.getEmployeesByJobId(request.getJobId());
        return new GetEmployeesByJobResponseDTO(employees, employees != null);
    }
}
