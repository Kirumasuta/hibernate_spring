package com.example.hibernate_spring.service;

import com.example.hibernate_spring.model.Organization;

import java.util.List;

public interface OrganizationService {

    Organization getOrganization(Integer id);

    List<Organization> getAllOrganization(Class<Organization> organizationClass);

    void addNewOrganization(Organization organization);
}
