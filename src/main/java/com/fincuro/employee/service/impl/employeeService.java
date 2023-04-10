package com.fincuro.employee.service.impl;

import com.fincuro.employee.employeeDto.EmployeeDto;
import com.fincuro.employee.entity.EmployeeEntity;

import java.util.List;
import java.util.Optional;

public interface employeeService {
    List<EmployeeDto> findAllEmployee();
    Optional<EmployeeDto> findbyEmployeeId(int id);
    EmployeeDto saveEmployee(EmployeeEntity entity);
    EmployeeDto updateEmployee(EmployeeEntity empEntity);
    void deleteEmployeeById(int id);

}
