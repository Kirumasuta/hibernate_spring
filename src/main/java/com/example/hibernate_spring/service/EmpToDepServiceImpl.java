package com.example.hibernate_spring.service;

import com.example.hibernate_spring.dao.EmpToDepDao;
import com.example.hibernate_spring.model.EmpToDep;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
public class EmpToDepServiceImpl implements EmpToDepService{

    @Autowired
    EmpToDepDao empToDepDao;

    @Override
    public EmpToDep getEmpToDep(Integer id) {
        return empToDepDao.findById(id);
    }

    @Override
    public void addNewEmpToDep(EmpToDep empToDep) {
        Integer id = (Integer) empToDepDao.save(empToDep);
    }

    @Override
    public EmpToDep getEmpToDepByEmpId(Integer id) {
        return empToDepDao.findByEmpId(id);
    }

    @Override
    public EmpToDep getEmpToDepByDepId(Integer id) {
        return empToDepDao.findByDepId(id);
    }

    @Override
    public List<EmpToDep> getAllEmpToDep(Class<EmpToDep> empToDepClass) {
        return empToDepDao.findAll(empToDepClass);
    }
}
