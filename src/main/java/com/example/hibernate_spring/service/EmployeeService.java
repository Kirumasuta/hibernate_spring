package com.example.hibernate_spring.service;

import com.example.hibernate_spring.model.Employee;

import java.util.List;

public interface EmployeeService {

    Employee getEmployee(Integer id);
    void addNewEmployee(Employee employee);
    List<Employee> getAllEmployees(Class<Employee> employeeClass);

}
