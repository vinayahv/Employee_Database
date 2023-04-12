package com.fincuro.employee.service.impl;

import com.fincuro.employee.employeeDto.EmployeeResponseDto;
import com.fincuro.employee.entity.EmployeeEntity;
import com.fincuro.employee.exceptions.DatabaseException;
import com.fincuro.employee.exceptions.ResourceNotFoundException;
import com.fincuro.employee.repository.EmployeeRepository;
import com.fincuro.employee.requestDto.EmployeeRequestDto;
import org.junit.jupiter.api.DisplayName;
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
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class EmployeeServiceImplementationTest {
  @InjectMocks
    EmployeeServiceImplementation employeeServiceImplementation;

    @Mock
    ModelMapper modelMapper;

    @Mock
    EmployeeRepository employeeRepository;

//    @AfterEach
//    void tearDown() throws Exception {
//        autoCloseable.close();
//    }

    @Test
    void findAllEmployee() {
     EmployeeEntity entity = new EmployeeEntity();
        List<EmployeeEntity> list = new ArrayList<>();
        list.add(entity);
        when(employeeRepository.findAll()).thenReturn(list);
        List<EmployeeResponseDto> allEmployee = employeeServiceImplementation.findAllEmployee();
        assertThat(allEmployee).isNotEmpty();
    }

    @Test
    void findByEmployeeId() {
        when(employeeRepository.findById(1)).thenReturn(Optional.of(new EmployeeEntity()));
        Optional<EmployeeResponseDto> employeeResponseDto = employeeServiceImplementation.findbyEmployeeId(1);
        assertThat(employeeResponseDto).isNotNull();
    }

    @DisplayName("name")
    @Test

    void saveEmployee() {
//        when(modelMapper.map(employeeRequestDto(), EmployeeEntity.class)).thenReturn(new EmployeeEntity()) ;
       when(employeeRepository.save(any(EmployeeEntity.class))).thenReturn(new EmployeeEntity());
       // when(modelMapper.map(new EmployeeEntity(), EmployeeResponseDto.class)).thenReturn(employeeResponseDto()) ;
        EmployeeResponseDto employeeResponseDto = employeeServiceImplementation.saveEmployee(employeeRequestDto());
        assertThat(employeeResponseDto).isNotNull();
    }


    @Test
    void updateEmployee()  {
        when(employeeRepository.save(any(EmployeeEntity.class))).thenReturn(new EmployeeEntity());
        Optional<EmployeeResponseDto> employeeResponseDto = Optional.ofNullable(employeeServiceImplementation.updateEmployee(employeeRequestDto()));
        assertThat(employeeResponseDto).isNotNull();
    }

    @Test
    void deleteEmployeeById() {
        when(employeeRepository.findById(1)).thenReturn(Optional.of(new EmployeeEntity()));
        String response = employeeServiceImplementation.deleteEmployeeById(1);
        assertThat(response).isEqualTo("DELETED");
    }

    @Test
    void test_save_employee_when_database_throws_error(){
        when(employeeRepository.save(any(EmployeeEntity.class))).thenThrow(new DatabaseException("Error while saving the data"));
        DatabaseException databaseException = assertThrows(DatabaseException.class, () -> employeeServiceImplementation.saveEmployee(new EmployeeRequestDto()));
        assertThat(databaseException.getMessage()).isEqualTo("Error while saving the employee details to the database");
    }

    @Test
    void test_update_employee_when_database_throws_error(){
        when(employeeRepository.save(any(EmployeeEntity.class))).thenThrow(new DatabaseException("Error while saving the data"));
        DatabaseException exception = assertThrows(DatabaseException.class,()-> employeeServiceImplementation.updateEmployee(employeeRequestDto()));
        assertThat(exception.getMessage()).isEqualTo("Error while saving the employee details to the database");
    }

    @Test
    void test_findById_employee_when_database_throws_error(){
        when(employeeRepository.findById(1)).thenThrow(new ResourceNotFoundException("Requested employee id is not exist"));
        ResourceNotFoundException resourceNotFoundException = assertThrows(ResourceNotFoundException.class, ()->employeeServiceImplementation.findbyEmployeeId(1));
        assertThat(resourceNotFoundException.getMessage()).isEqualTo("Requested employee id is not exist");
    }

    @Test
    void test_deleteById_employee_when_database_throws_error(){
        when(employeeRepository.findById(1)).thenThrow(new ResourceNotFoundException("Requested employee id is not exist"));
        ResourceNotFoundException resourceNotFoundException = assertThrows(ResourceNotFoundException.class, ()->employeeServiceImplementation.deleteEmployeeById(1));
        assertThat(resourceNotFoundException.getMessage()).isEqualTo("Requested employee id is not exist");
    }

    private EmployeeRequestDto employeeRequestDto(){
        EmployeeRequestDto emp=new EmployeeRequestDto();
        emp.setName("Vishal");
        emp.setGender("Male");
        return  emp;
    }

    private EmployeeResponseDto employeeResponseDto(){
        EmployeeResponseDto emp1= new EmployeeResponseDto();
        emp1.setName("XYZ");
        emp1.setGender("Female");
        return emp1;
    }


}