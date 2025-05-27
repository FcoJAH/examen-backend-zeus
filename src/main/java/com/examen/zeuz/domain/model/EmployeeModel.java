package com.examen.zeuz.domain.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Data
@AllArgsConstructor
public class EmployeeModel {
    private Integer id;
    private String name;
    private String lastName;
    private LocalDate birthdate;
    private Integer genderId;
    private Integer jobId;
}
