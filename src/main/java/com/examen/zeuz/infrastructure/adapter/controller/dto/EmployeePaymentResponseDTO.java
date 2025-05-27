package com.examen.zeuz.infrastructure.adapter.controller.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class EmployeePaymentResponseDTO {
    private Integer payment;
    private boolean success;
}
