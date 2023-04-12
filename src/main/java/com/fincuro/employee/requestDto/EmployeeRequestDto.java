package com.fincuro.employee.requestDto;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class EmployeeRequestDto {
    @NotNull(message="Name should not be null")
    private String name;

    @NotNull(message="Gender should not be null")
    private String gender;

}
