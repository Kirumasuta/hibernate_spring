package com.example.hibernate_spring.dao;

import com.example.hibernate_spring.model.EmpToDep;

import java.io.Serializable;
import java.util.List;

public interface EmpToDepDao {

    Serializable save(EmpToDep empToDep);
    EmpToDep findById(Serializable id);

    EmpToDep findByEmpId(Serializable id);
    EmpToDep findByDepId(Serializable id);
    List<EmpToDep> findAll(Class<EmpToDep> empToDepClass);
}
