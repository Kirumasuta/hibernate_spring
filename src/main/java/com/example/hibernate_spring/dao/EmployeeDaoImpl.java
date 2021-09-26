package com.example.hibernate_spring.dao;

import com.example.hibernate_spring.model.Employee;
import com.example.hibernate_spring.model.Organization;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import java.io.Serializable;
import java.util.List;

@Repository
public class EmployeeDaoImpl implements EmployeeDao {

    @Autowired
    private SessionFactory sessionFactory;

    protected Session getSession(){
        return this.sessionFactory.getCurrentSession();
    }

    @Override
    public Serializable save(Employee employee) {
        return getSession().save(employee);
    }

    @Override
    public Employee findById(Serializable id) {
        return getSession().get(Employee.class, id);
    }

    @Override
    public List<Employee> findAll(Class<Employee> employeeClass) {
        Session session = getSession();
        CriteriaBuilder b = session.getCriteriaBuilder();
        CriteriaQuery<Employee> cq = b.createQuery(employeeClass);
        cq.from(employeeClass);
        List<Employee> dataList = session.createQuery(cq).getResultList();
        return dataList;
    }
}
