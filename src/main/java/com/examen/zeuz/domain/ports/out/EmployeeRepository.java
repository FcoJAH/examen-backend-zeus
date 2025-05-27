package com.examen.zeuz.domain.ports.out;

import com.examen.zeuz.domain.model.EmployeeModel;

public interface EmployeeRepository {
    boolean existsByNameAndLastName(String name, String lastName);
    boolean genderExists(int genderId);
    boolean jobExists(int jobId);
    Integer save(EmployeeModel employeeModel);
}
