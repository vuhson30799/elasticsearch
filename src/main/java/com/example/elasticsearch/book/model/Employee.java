package com.example.elasticsearch.book.model;

import org.springframework.data.elasticsearch.annotations.Document;

import javax.persistence.*;

@Document(indexName= "ducat", type= "employee")
@Entity
@Table(name = "employee")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String designation;

    public Employee() { }

    public Employee(Long id, String name, String designation) {
        this.id = id;
        this.name = name;
        this.designation = designation;
    }

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getDesignation() {
        return designation;
    }
    public void setDesignation(String designation) {
        this.designation = designation;
    }

    @Override
    public String toString() {
        return "Employee [id=" + id + ", name=" + name + ", designation=" + designation + "]";
    }
}
