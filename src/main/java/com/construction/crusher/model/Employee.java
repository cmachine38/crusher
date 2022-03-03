package com.construction.crusher.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "employee_master")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Employee {

    @Id
    @Column(name = "emp_aadhar")
    private String employeeAadhar;

    @Column(name = "emp_first_name")
    private String firstname;

    @Column(name = "emp_midldle_name")
    private String middlename;

    @Column(name = "emp_last_name")
    private String lastname;

    @Column(name = "emp_address")
    private String address;

    @Column(name = "emp_phone")
    private String phone;

    @Column(name = "emp_alternate_phone")
    private String alternatePhone;

    @Column(name = "emp_age")
    private String age;

    @Column(name = "emp_sex")
    private String sex;

    @Column(name = "emp_marital_status")
    private String maritalStatus;

}