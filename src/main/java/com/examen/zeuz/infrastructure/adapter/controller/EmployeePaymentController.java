package com.examen.zeuz.infrastructure.adapter.controller;

import com.examen.zeuz.domain.ports.in.GetEmployeePaymentUseCase;
import com.examen.zeuz.infrastructure.adapter.controller.dto.EmployeePaymentRequestDTO;
import com.examen.zeuz.infrastructure.adapter.controller.dto.EmployeePaymentResponseDTO;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/pagos")
public class EmployeePaymentController {
    @Autowired
    private GetEmployeePaymentUseCase useCase;

    @PostMapping("/resumen")
    public EmployeePaymentResponseDTO getPayment(@Valid @RequestBody EmployeePaymentRequestDTO request) {
        var result = useCase.getPayment(request.getEmployeeId(), request.getStartDate(), request.getEndDate());
        return new EmployeePaymentResponseDTO(result.getPayment(), result.isSuccess());
    }
}
