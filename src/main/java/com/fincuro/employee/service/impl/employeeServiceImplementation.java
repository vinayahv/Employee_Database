package com.fincuro.employee.service.impl;
import com.fincuro.employee.employeeDto.EmployeeDto;
import com.fincuro.employee.entity.EmployeeEntity;
import com.fincuro.employee.exceptions.DatabaseException;
import com.fincuro.employee.exceptions.ResourceNotFoundException;
import com.fincuro.employee.repository.EmployeeRepository;
import com.google.gson.reflect.TypeToken;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class employeeServiceImplementation implements employeeService {
        ModelMapper modelmapper= new ModelMapper();
        private final EmployeeRepository empRepository;

    public employeeServiceImplementation(EmployeeRepository empRepository) {
        this.empRepository = empRepository;
    }


    /**
     * findAllEmployee method
     *
     * @return it return the list of employee
     *
     */
    @Override
        public List<EmployeeDto> findAllEmployee() {
            List<EmployeeEntity> employeeEntity = empRepository.findAll();
            Type listType = new TypeToken<ArrayList<EmployeeDto>>() {
            }.getType();
            return modelmapper.map(employeeEntity, listType);
        }

    /**
     * findByEmployeeId method
     * @param id employeeId
     * @return employee details
     */
    @Override
        public Optional<EmployeeDto> findbyEmployeeId(int id) {

        Optional<EmployeeEntity> employeeById = empRepository.findById(id);
        if(employeeById.isPresent() == false) {
            log.error("Requested employee id is not exist");
            throw new ResourceNotFoundException("Requested employee id is not exist");
        }
            EmployeeDto map = modelmapper.map(employeeById, EmployeeDto.class);
            return Optional.ofNullable(map);
        }

    /**
     * saveEmployee method
     * @param employeeentity savingEmployee
     * @return saved employee
     */
    @Override
        public EmployeeDto saveEmployee(EmployeeEntity employeeentity) {
            EmployeeEntity entity;
            try{
                entity=empRepository.save(employeeentity);
            }
            catch (Exception exception){
                log.error("Error while saving the employee details to the database", exception);
                throw new DatabaseException("Error while saving the employee details to the database");
            }


            EmployeeDto dto=modelmapper.map(entity,EmployeeDto.class);
            return dto;
        }

    /**
     * updateEmployee method
     * @param employeeEntity updating employee entity
     * @return updated employee entity
     */
    @Override
        public EmployeeDto updateEmployee(EmployeeEntity employeeEntity) {
            EmployeeEntity entity;
        try{
            entity=empRepository.save(employeeEntity);
        }
        catch (Exception exception){
            log.error("Error while saving the employee details to the database", exception);
            throw new DatabaseException("Error while saving the employee details to the database");
        }

        EmployeeDto dto=modelmapper.map(entity,EmployeeDto.class);
            return dto;

        }

    /**
     * deleteEmployeeId method
     * @param id deleteById
     *
     */
    @Override
        public void deleteEmployeeById(int id) {
        Optional<EmployeeEntity> byId = empRepository.findById(id);

        if(!byId.isPresent()) {
            log.error("Requested employee id is not exist");
            throw new ResourceNotFoundException("Requested employee id is not exist");
        }
        empRepository.deleteById(id);

        }

    }
