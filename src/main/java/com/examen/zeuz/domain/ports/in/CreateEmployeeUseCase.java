package com.examen.zeuz.domain.ports.in;

import com.examen.zeuz.domain.model.EmployeeModel;

public interface CreateEmployeeUseCase {
    Integer createEmployee(EmployeeModel employeeModel);
}
