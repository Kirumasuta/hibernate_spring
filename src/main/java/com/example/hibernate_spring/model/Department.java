package com.example.hibernate_spring.model;

import javax.persistence.*;

@Table(name = "department")
@Entity
public class Department {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @ManyToOne(optional = false)
    @JoinColumn(name = "org_id", nullable = false)
    private Organization org_id;

    @Column(name = "dep_id")
    private Integer dep_id;

    @Column(name = "name", nullable = false, length = 256)
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getDepId() {
        return dep_id;
    }

    public void setDepId(Integer depId) {
        this.dep_id = depId;
    }

    public Organization getOrg() {
        return org_id;
    }

    public void setOrg(Organization org) {
        this.org_id = org;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}