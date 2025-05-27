package com.examen.zeuz.domain.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
public class JobModel {
    private Integer id;
    private String name;
    private BigDecimal salary;
}
