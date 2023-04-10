package com.fincuro.employee.employeeDto;

import lombok.Data;
import lombok.NonNull;
import org.aspectj.bridge.IMessage;

import javax.persistence.Column;
import javax.validation.constraints.NotNull;

@Data
public class EmployeeDto {

    private int id;
    @NotNull(message="Name should not be null")
    private String name;

    @NotNull(message="Gender should not be null")
    private String gender;
}
