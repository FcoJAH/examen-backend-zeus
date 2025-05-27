package com.examen.zeuz.infrastructure.adapter.controller.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class GetEmployeesByJobRequestDTO {
    @NotNull
    private Integer jobId;
}
