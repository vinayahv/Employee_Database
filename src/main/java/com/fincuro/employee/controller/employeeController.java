package com.fincuro.employee.controller;


import com.fincuro.employee.employeeDto.EmployeeDto;
import com.fincuro.employee.entity.EmployeeEntity;
import com.fincuro.employee.service.impl.employeeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
@Slf4j
@RestController
@RequestMapping("/employee")
public class employeeController {
    private  final employeeService empService;

    public employeeController(employeeService empService) {
        this.empService = empService;
    }
    @GetMapping
    public List<EmployeeDto>findAllEmp(){
        log.info("Find all employee started");
        return empService.findAllEmployee();
    }
    @GetMapping("/{id}")
    public Optional<EmployeeDto> findbyid(@PathVariable("id") int id){

        return empService.findbyEmployeeId(id);
    }


    @PostMapping
    public EmployeeDto saveEmployee(@RequestBody EmployeeEntity empEntity){
        return empService.saveEmployee(empEntity);
    }
    @PutMapping
    public EmployeeDto updateEmployee(@RequestBody EmployeeEntity empEntity){

        return empService.updateEmployee(empEntity);
    }

    @DeleteMapping("/{id}")
    public void deleteEmployee(@PathVariable("id")int id){
        empService.deleteEmployeeById(id);
    }
}



