package com.example.hibernate_spring.model;

import javax.persistence.*;

@Table(name = "emp_to_dep")
@Entity
public class EmpToDep {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @ManyToOne(optional = false)
    @JoinColumn(name = "emp_id", nullable = false)
    private EmpToDep emp_id;

    @ManyToOne(optional = false)
    @JoinColumn(name = "dep_id", nullable = false)
    private Department dep_id;

    public Department getDep() {
        return dep_id;
    }

    public void setDep(Department dep) {
        this.dep_id = dep;
    }

    public EmpToDep getEmp() {
        return emp_id;
    }

    public void setEmp(EmpToDep emp) {
        this.emp_id = emp;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}