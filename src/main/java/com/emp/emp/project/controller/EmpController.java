package com.emp.emp.project.controller;

import com.emp.emp.project.entity.EmpEntity;
import com.emp.emp.project.service.EmpService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/employee")
public class EmpController {
    private  final EmpService empService;

    public EmpController(EmpService empService) {
        this.empService = empService;
    }
    @GetMapping
    public List<EmpEntity>findAllEmp(){
        return empService.findAllEmp();
    }
    @GetMapping("/{id}")
    public Optional<EmpEntity> findbyid(@PathVariable("id") int id){
        return empService.findbyid(id);
    }


    @PostMapping
    public EmpEntity saveEmployee(@RequestBody EmpEntity empEntity){
        return empService.saveEmployee(empEntity);
    }
    @PutMapping
    public EmpEntity updateEmployee(@RequestBody EmpEntity empEntity){
        return empService.updateEmployee(empEntity);
    }

    @DeleteMapping("/{id}")
    public void deleteEmployee(@PathVariable("id")int id){
        empService.deleteEmployee(id);
    }
}
