package com.emp.emp.project.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name="empdb")
@Data
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
