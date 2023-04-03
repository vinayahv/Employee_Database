package com.emp.emp.project.service.impl;

import com.emp.emp.project.entity.EmpEntity;
import com.emp.emp.project.repository.EmpRepository;
import com.emp.emp.project.service.EmpService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class empServiceImpl implements EmpService {
    private final EmpRepository empRepository;

    public empServiceImpl(EmpRepository empRepository) {
        this.empRepository = empRepository;
    }

    @Override
    public List<EmpEntity> findAllEmp() {
        return empRepository.findAll();
    }

    @Override
    public Optional<EmpEntity> findbyid(int id) {
        return empRepository.findById(id);
    }

    @Override
    public EmpEntity saveEmployee(EmpEntity empEntity) {
        return empRepository.save(empEntity) ;
    }

    @Override
    public EmpEntity updateEmployee(EmpEntity empEntity) {
        return empRepository.save(empEntity);
    }

    @Override
    public void deleteEmployee(int id) {
        empRepository.deleteById(id);
    }
}
