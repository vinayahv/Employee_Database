package com.emp.emp.project.repository;

import com.emp.emp.project.entity.EmpEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmpRepository extends JpaRepository<EmpEntity,Integer> {
}
