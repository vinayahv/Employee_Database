package com.emp.emp.project.entity;



import javax.annotation.sql.DataSourceDefinition;
import javax.persistence.*;

@Entity
@Table(name="empdb")

public class EmpEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name= "emp_id")
    private int id;

    @Column(name= "emp_name")
    private String name;

    @Column(name= "emp_gender")
    private String gender;


}
