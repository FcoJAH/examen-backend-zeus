package com.examen.zeuz.domain.ports.in;

import com.examen.zeuz.domain.model.EmployeePaymentSummaryModel;

import java.time.LocalDate;

public interface GetEmployeePaymentUseCase {
    EmployeePaymentSummaryModel getPayment(Integer employeeId, LocalDate startDate, LocalDate endDate);
}
