package com.example.hibernate_spring.dao;

import com.example.hibernate_spring.model.Employee;

import java.io.Serializable;
import java.util.List;

public interface EmployeeDao {

    Serializable save(Employee employee);
    Employee findById(Serializable id);
    List<Employee> findAll(Class<Employee> employeeClass);

}
