package com.example.hibernate_spring.dao;


import com.example.hibernate_spring.model.Organization;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import java.io.Serializable;
import java.util.List;

@Repository
public class OrganizationDaoImpl implements OrganizationDao{

    @Autowired
    private SessionFactory sessionFactory;

    protected Session getSession(){
        return this.sessionFactory.getCurrentSession();
    }

    @Override
    public Serializable save(Organization organization){
        return getSession().save(organization);
    }

    @Override
    public Organization findById(final Serializable id) {
        return getSession().get(Organization.class, id);
    }

    @Override
    public List<Organization> findAll(Class<Organization> organizationClass) {
        Session session = getSession();
        CriteriaBuilder b = session.getCriteriaBuilder();
        CriteriaQuery<Organization> cq = b.createQuery(organizationClass);
        cq.from(organizationClass);
        List<Organization> dataList = session.createQuery(cq).getResultList();
        return dataList;
    }
}
