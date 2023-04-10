package com.fincuro.employee.controller;
import com.fincuro.employee.employeeDto.EmployeeResponseDto;
import com.fincuro.employee.entity.EmployeeEntity;
import com.fincuro.employee.requestDto.EmployeeRequestDto;
import com.fincuro.employee.service.impl.EmployeeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;


@Slf4j
@RestController
@RequestMapping("/employee")
public class EmployeeController {
    private  final EmployeeService empService;

    public EmployeeController(EmployeeService empService) {
        this.empService = empService;
    }
    @GetMapping
    public List<EmployeeResponseDto>findAllEmp(){
        log.info("Find all employee started");
        return empService.findAllEmployee();
    }
    @GetMapping("/{id}")
    public Optional<EmployeeResponseDto> findByEmployeeId(@PathVariable("id") int id){

        return empService.findbyEmployeeId(id);
    }


    @PostMapping
    public EmployeeResponseDto saveEmployee(@Valid @RequestBody EmployeeRequestDto employeeRequestDto){
        return empService.saveEmployee(employeeRequestDto);
    }
    @PutMapping
    public EmployeeResponseDto updateEmployee(@Valid@RequestBody EmployeeRequestDto empEntity){

        return empService.updateEmployee(empEntity);

    }

    @DeleteMapping("/{id}")
    public void deleteEmployee(@PathVariable("id")int id){
        empService.deleteEmployeeById(id);
    }
}



