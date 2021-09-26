package com.example.hibernate_spring.service;

import com.example.hibernate_spring.model.EmpToDep;

import java.util.List;

public interface EmpToDepService {

    EmpToDep getEmpToDep(Integer id);
    void addNewEmpToDep(EmpToDep empToDep);
    EmpToDep getEmpToDepByEmpId(Integer id);
    EmpToDep getEmpToDepByDepId(Integer id);
    List<EmpToDep> getAllEmpToDep(Class<EmpToDep> empToDepClass);

}
