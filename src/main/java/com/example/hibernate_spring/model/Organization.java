package com.example.hibernate_spring.model;

import javax.persistence.*;
import java.io.Serializable;

@Table(name = "Organization")
@Entity
public class Organization implements Serializable{

    private Integer id;
    private String name;

    public Organization() {

    }

    public Organization(String name){
        this.id = getId();
        this.name = name;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}