package com.example.hibernate_spring.service;

import com.example.hibernate_spring.model.Department;

import java.util.List;

public interface DepartmentService {

    Department getDepartment(Integer id);

    List<Department> getDepartmentByOrganization(Integer id);

    List<Department> getDepartmentByDepartment(Integer id);

    void addNewDepartment(Department department);
}
