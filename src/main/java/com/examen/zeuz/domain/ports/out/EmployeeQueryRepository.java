package com.examen.zeuz.domain.ports.out;

import com.examen.zeuz.domain.model.EmployeeWithDetailsModel;

import java.util.List;

public interface EmployeeQueryRepository {
    boolean jobExists(int jobId);
    List<EmployeeWithDetailsModel> findByJobId(int jobId);
}
