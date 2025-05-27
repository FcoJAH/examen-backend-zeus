package com.examen.zeuz.domain.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDate;

@Data
@AllArgsConstructor
public class EmployeeWithDetailsModel {
    private Integer id;
    private String name;
    private String lastName;
    private LocalDate birthdate;
    private JobModel job;
    private GenderModel gender;
}
