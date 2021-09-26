package com.example.hibernate_spring.dao;

import com.example.hibernate_spring.model.Organization;

import java.io.Serializable;
import java.util.List;

public interface OrganizationDao {

    Serializable save(Organization organization);
    Organization findById(Serializable id);
    List<Organization> findAll(Class<Organization> organizationClass);
}
