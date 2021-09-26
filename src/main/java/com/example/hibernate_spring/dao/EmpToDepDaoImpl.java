package com.example.hibernate_spring.dao;

import com.example.hibernate_spring.model.Department;
import com.example.hibernate_spring.model.EmpToDep;
import com.example.hibernate_spring.model.Organization;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.io.Serializable;
import java.util.List;

@Repository
public class EmpToDepDaoImpl implements EmpToDepDao{

    @Autowired
    private SessionFactory sessionFactory;

    protected Session getSession(){ return this.sessionFactory.getCurrentSession(); }

    @Override
    public Serializable save(EmpToDep empToDep) {
        return  getSession().save(empToDep);
    }

    @Override
    public EmpToDep findById(Serializable id) {
        return getSession().get(EmpToDep.class, id);
    }

    @Override
    public EmpToDep findByEmpId(Serializable id) {
        Session session = getSession();
        CriteriaBuilder b = session.getCriteriaBuilder();
        CriteriaQuery<EmpToDep> cq = b.createQuery(EmpToDep.class);
        Root<EmpToDep> root = cq.from(EmpToDep.class);
        cq.where(b.equal(root.get("emp_id"), id));

        Query<EmpToDep> query = session.createQuery(cq);
        System.out.println(query.getClass());
        List<EmpToDep> dataList = query.list();
        return dataList.get(0);
    }

    @Override
    public EmpToDep findByDepId(Serializable id) {
        Session session = getSession();
        CriteriaBuilder b = session.getCriteriaBuilder();
        CriteriaQuery<EmpToDep> cq = b.createQuery(EmpToDep.class);
        Root<EmpToDep> root = cq.from(EmpToDep.class);
        cq.where(b.equal(root.get("dep_id"), id));

        Query<EmpToDep> query = session.createQuery(cq);
        System.out.println(query.getClass());
        List<EmpToDep> dataList = query.list();
        return dataList.get(0);
    }

    @Override
    public List<EmpToDep> findAll(Class<EmpToDep> empToDepClass) {
        Session session = getSession();
        CriteriaBuilder b = session.getCriteriaBuilder();
        CriteriaQuery<EmpToDep> cq = b.createQuery(empToDepClass);
        cq.from(empToDepClass);
        List<EmpToDep> dataList = session.createQuery(cq).getResultList();
        return dataList;
    }
}
