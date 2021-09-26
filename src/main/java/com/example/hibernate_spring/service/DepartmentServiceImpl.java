package com.example.hibernate_spring.service;

import com.example.hibernate_spring.dao.DepartmentDao;
import com.example.hibernate_spring.model.Department;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
public class DepartmentServiceImpl implements DepartmentService{

    @Autowired
    DepartmentDao departmentDao;

    @Override
    public Department getDepartment(Integer id) {
        return departmentDao.findById(id);
    }

    @Override
    public List<Department> getDepartmentByOrganization(Integer id) {
        return departmentDao.findByOrganizationId(id);
    }

    @Override
    public List<Department> getDepartmentByDepartment(Integer id) {
        return departmentDao.findByDepId(id);
    }

    @Override
    public void addNewDepartment(Department department) {
        Integer id = (Integer) departmentDao.save(department);
    }
}
