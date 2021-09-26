package com.example.hibernate_spring.service;

import com.example.hibernate_spring.dao.OrganizationDao;
import com.example.hibernate_spring.model.Organization;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
@Transactional(readOnly = true)
public class OrganizationServiceImpl implements OrganizationService{

    @Autowired
    OrganizationDao organizationDao;

    @Override
    public Organization getOrganization(Integer id) {
        return organizationDao.findById(id);
    }

    @Override
    public List<Organization> getAllOrganization(Class<Organization> organizationClass) {
        return organizationDao.findAll(organizationClass);
    }

    @Override
    public void addNewOrganization(Organization organization) {
        Integer id = (Integer) organizationDao.save(organization);
    }
}
