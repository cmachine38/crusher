package com.construction.crusher.service;


import com.construction.crusher.model.Employee;
import com.construction.crusher.repo.EmployeeRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;




@Service
@Transactional(readOnly = false)
public class EmployeeService {

    private EmployeeRepository employeeRepository;

    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }


    public Iterable<Employee> findAll() {
        System.out.println("***************************inside service" + employeeRepository);
        return employeeRepository.findAll();
    }

    @Transactional(rollbackFor = Exception.class)
    public Employee create(Employee employee) {
        return employeeRepository.save(employee);
    }

    @Transactional(rollbackFor = Exception.class)
    public void delete(Employee employee) {
        employeeRepository.delete(employee);
    }

    @Transactional(rollbackFor = Exception.class)
    public Employee find(String aadhar) {
        return employeeRepository.findByEmployeeAadhar(aadhar);
    }

}