package com.examen.zeuz.domain.ports.in;

import com.examen.zeuz.domain.model.EmployeeWithDetailsModel;

import java.util.List;

public interface GetEmployeesByJobUseCase {
    List<EmployeeWithDetailsModel> getEmployeesByJobId(Integer jobId);
}
