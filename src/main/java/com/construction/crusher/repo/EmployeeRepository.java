package com.construction.crusher.repo;

import com.construction.crusher.model.Employee;
import org.springframework.data.repository.CrudRepository;

public interface EmployeeRepository extends CrudRepository<Employee, String> {

   Employee findByEmployeeAadhar(String employeeAadhar);
}