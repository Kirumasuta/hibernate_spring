package com.example.hibernate_spring.dao;

import com.example.hibernate_spring.model.Department;
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
public class DepartmentDaoImpl implements DepartmentDao{

    @Autowired
    private SessionFactory sessionFactory;

    protected Session getSession(){
        return this.sessionFactory.getCurrentSession();
    }

    @Override
    public Serializable save(Department department) {
        return getSession().save(department);
    }

    @Override
    public Department findById(Serializable id) {
        return getSession().get(Department.class, id);
    }

    @Override
    public List<Department> findByOrganizationId(Serializable id) {
        Session session = getSession();
        CriteriaBuilder b = session.getCriteriaBuilder();
        CriteriaQuery<Department> cq = b.createQuery(Department.class);
        Root<Department> root = cq.from(Department.class);
        cq.where(b.equal(root.get("org_id"), id));

        Query<Department> query = session.createQuery(cq);
        System.out.println(query.getClass());
        List<Department> dataList = query.list();
        return dataList;
    }

    @Override
    public List<Department> findByDepId(Serializable id) {
        Session session = getSession();
        CriteriaBuilder b = session.getCriteriaBuilder();
        CriteriaQuery<Department> cq = b.createQuery(Department.class);
        Root<Department> root = cq.from(Department.class);
        cq.where(b.equal(root.get("dep_id"), id));

        Query<Department> query = session.createQuery(cq);
        List<Department> dataList = query.list();
        return dataList;
    }
}
