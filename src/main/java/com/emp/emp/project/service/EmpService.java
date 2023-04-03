package com.emp.emp.project.service;

import com.emp.emp.project.entity.EmpEntity;

import java.util.List;
import java.util.Optional;

public interface EmpService {
    List<EmpEntity> findAllEmp();
    Optional<EmpEntity> findbyid(int id);
    EmpEntity saveEmployee(EmpEntity empEntity);
    EmpEntity updateEmployee(EmpEntity empEntity);
    void deleteEmployee(int id);

}
