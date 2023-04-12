package com.fincuro.employee.service.impl;
import com.fincuro.employee.employeeDto.EmployeeResponseDto;
import com.fincuro.employee.entity.EmployeeEntity;
import com.fincuro.employee.exceptions.DatabaseException;
import com.fincuro.employee.exceptions.ResourceNotFoundException;
import com.fincuro.employee.repository.EmployeeRepository;
import com.fincuro.employee.requestDto.EmployeeRequestDto;
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
public class EmployeeServiceImplementation implements EmployeeService {
        ModelMapper modelmapper= new ModelMapper();
        private final EmployeeRepository empRepository;

    public EmployeeServiceImplementation(EmployeeRepository empRepository) {
        this.empRepository = empRepository;
    }


    /**
     * findAllEmployee method
     *
     * @return it return the list of employee
     *
     */
    @Override
        public List<EmployeeResponseDto> findAllEmployee() {
            List<EmployeeEntity> employeeEntity = empRepository.findAll();
            Type listType = new TypeToken<ArrayList<EmployeeResponseDto>>() {
            }.getType();
            return modelmapper.map(employeeEntity, listType);
        }

    /**
     * findByEmployeeId method
     * @param id employeeId
     * @return employee details
     */
    @Override
        public Optional<EmployeeResponseDto> findbyEmployeeId(int id) {

        Optional<EmployeeEntity> employeeById = empRepository.findById(id);
        if(!employeeById.isPresent()) {
            log.error("Requested employee id is not exist");
            throw new ResourceNotFoundException("Requested employee id is not exist");
        }
            EmployeeResponseDto map = modelmapper.map(employeeById, EmployeeResponseDto.class);
            return Optional.ofNullable(map);
    }

    /**
     * saveEmployee method
     * @param employeeRequestDto savingEmployee
     * @return saved employee
     */
    @Override
        public EmployeeResponseDto saveEmployee(EmployeeRequestDto employeeRequestDto) {
        EmployeeEntity map = modelmapper.map(employeeRequestDto, EmployeeEntity.class);
        EmployeeEntity entity;
            try{
                entity=empRepository.save(map);
            }
            catch (Exception exception){
                log.error("Error while saving the employee details to the database", exception);
                throw new DatabaseException("Error while saving the employee details to the database");
            }
            EmployeeResponseDto dto=modelmapper.map(entity, EmployeeResponseDto.class);
            return dto;
        }

    /**
     * updateEmployee method
     * @param employeeRequestDto updating employee entity
     * @return updated employee entity
     */
    @Override
        public EmployeeResponseDto updateEmployee(EmployeeRequestDto employeeRequestDto){
        EmployeeEntity map = modelmapper.map(employeeRequestDto, EmployeeEntity.class);
        EmployeeEntity entity;

        try{
            entity=empRepository.save(map);
        }
        catch (Exception exception){
            log.error("Error while saving the employee details to the database", exception);
            throw new DatabaseException("Error while saving the employee details to the database");
        }

        EmployeeResponseDto dto=modelmapper.map(entity, EmployeeResponseDto.class);
            return dto;

        }

    /**
     * deleteEmployeeId method
     * @param id deleteById
     *
     */
    @Override
        public String deleteEmployeeById(int id) {
        Optional<EmployeeEntity> byId = empRepository.findById(id);

        if(!byId.isPresent()) {
            log.error("Requested employee id is not exist");
            throw new ResourceNotFoundException("Requested employee id is not exist");
        }
        empRepository.deleteById(id);
        return "DELETED";

        }

    }
