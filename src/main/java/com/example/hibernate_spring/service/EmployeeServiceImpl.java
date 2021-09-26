package com.example.hibernate_spring.service;

import com.example.hibernate_spring.dao.EmployeeDao;
import com.example.hibernate_spring.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    EmployeeDao employeeDao;

    @Override
    public Employee getEmployee(Integer id) {
        return employeeDao.findById(id);
    }

    @Override
    public void addNewEmployee(Employee employee) {
        Integer id = (Integer) employeeDao.save(employee);
    }

    @Override
    public List<Employee> getAllEmployees(Class<Employee> employeeClass) {
        return employeeDao.findAll(employeeClass);
    }
}
