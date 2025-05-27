package com.examen.zeuz.infrastructure.adapter.controller.dto;

import com.examen.zeuz.domain.model.EmployeeWithDetailsModel;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class GetEmployeesByJobResponseDTO {
    private List<EmployeeWithDetailsModel> employees;
    private boolean success;
}
