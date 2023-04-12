package com.fincuro.employee.service.impl;

import com.fincuro.employee.employeeDto.EmployeeResponseDto;
import com.fincuro.employee.entity.EmployeeEntity;
import com.fincuro.employee.requestDto.EmployeeRequestDto;

import java.util.List;
import java.util.Optional;

public interface EmployeeService {
    List<EmployeeResponseDto> findAllEmployee();
    Optional<EmployeeResponseDto> findbyEmployeeId(int id);
    EmployeeResponseDto saveEmployee(EmployeeRequestDto entity);
    EmployeeResponseDto updateEmployee(EmployeeRequestDto empEntity);
    String deleteEmployeeById(int id);

}
