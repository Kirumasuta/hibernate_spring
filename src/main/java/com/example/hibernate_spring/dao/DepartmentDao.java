package com.example.hibernate_spring.dao;

import com.example.hibernate_spring.model.Department;

import java.io.Serializable;
import java.util.List;

public interface DepartmentDao {

    Serializable save(Department department);
    Department findById(Serializable id);
    List<Department> findByOrganizationId(Serializable id);
    List<Department> findByDepId(Serializable id);

}
