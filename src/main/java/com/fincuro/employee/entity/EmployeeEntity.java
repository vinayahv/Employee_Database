package com.fincuro.employee.entity;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.Data;
import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="empdb")
@Data
public class EmployeeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name= "emp_id")
    private int id;

    @Column(name= "emp_name")
    @NotNull(message="UserName should not be null")
    private String name;

    @Column(name= "emp_gender")
    @NotNull(message="Gender should not be null")
    private String gender;


}
