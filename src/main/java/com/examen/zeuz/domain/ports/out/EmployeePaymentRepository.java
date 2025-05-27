package com.examen.zeuz.domain.ports.out;

import java.time.LocalDate;

public interface EmployeePaymentRepository {
    boolean employeeExists(int employeeId);
    Integer getPayment(int employeeId, LocalDate startDate, LocalDate endDate);
}
