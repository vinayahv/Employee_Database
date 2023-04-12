package com.fincuro.employee.controller;

import com.fincuro.employee.employeeDto.EmployeeResponseDto;
import com.fincuro.employee.entity.EmployeeEntity;
import com.fincuro.employee.requestDto.EmployeeRequestDto;
import com.fincuro.employee.service.impl.EmployeeService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.modelmapper.ModelMapper;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class EmployeeControllerTest {

    @InjectMocks
    EmployeeController employeeController;

    @Mock
    ModelMapper modelMapper;

    @Mock
    EmployeeService employeeService;

    @Test
    void findAllEmp() {
        EmployeeEntity entity = new EmployeeEntity();
        List<EmployeeResponseDto> list = new ArrayList<>();
        list.add(employeeResponseDto());
        when(employeeService.findAllEmployee()).thenReturn(list);
        List<EmployeeResponseDto> allEmployee = employeeController.findAllEmp();
        assertThat(allEmployee).isNotEmpty();
    }

    @Test
    void findByEmployeeId() {
        when(employeeService.findbyEmployeeId(1)).thenReturn(Optional.of(employeeResponseDto()));
       Optional<EmployeeResponseDto> employeeResponseDto = employeeController.findByEmployeeId(1);
        assertThat(employeeResponseDto).isNotNull();

    }

    @Test
    void saveEmployee() {
        when(employeeService.saveEmployee(employeeRequestDto())).thenReturn(employeeResponseDto());
        EmployeeResponseDto employeeResponseDto = employeeController.saveEmployee(employeeRequestDto());
        assertThat(employeeResponseDto).isNotNull();
    }

    @Test
    void updateEmployee() {
        when(employeeService.updateEmployee(employeeRequestDto())).thenReturn(employeeResponseDto());
        Optional<EmployeeResponseDto> employeeResponseDto = Optional.ofNullable(employeeController.updateEmployee(employeeRequestDto()));
        assertThat(employeeResponseDto).isNotNull();
    }

    @Test
    void deleteEmployee() {
        when(employeeService.deleteEmployeeById(1)).thenReturn("DELETED");
        String response = employeeController.deleteEmployee(1);
        assertThat(response).isEqualTo("DELETED");
    }

//    void deleteEmployee() {
//        when(employeeService.findbyEmployeeId(1)).thenReturn(Optional.of(employeeResponseDto()));
//        String response = employeeController.deleteEmployee(1);
//        assertThat(response).isEqualTo("DELETED");
//    }

    private EmployeeRequestDto employeeRequestDto() {
        EmployeeRequestDto emp = new EmployeeRequestDto();
        emp.setName("Vishal");
        emp.setGender("Male");
        return emp;
    }

    private EmployeeResponseDto employeeResponseDto() {
        EmployeeResponseDto emp1 = new EmployeeResponseDto();
        emp1.setName("Vishal");
        emp1.setGender("Male");
        return emp1;
    }


}