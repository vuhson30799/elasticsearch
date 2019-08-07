package com.example.elasticsearch.book.service;

import com.example.elasticsearch.book.model.Employee;

import java.util.List;

public interface EmployeeEsService {
    Iterable<Employee> findAll();
    List<Employee> findByDesignation(String designation);
    void save(Employee employee);
    void delete(Employee employee);
    void update(Employee employee);
}
