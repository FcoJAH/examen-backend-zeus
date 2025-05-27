package com.examen.zeuz.domain.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class EmployeePaymentSummaryModel {
    private Integer payment;
    private boolean success;
}
