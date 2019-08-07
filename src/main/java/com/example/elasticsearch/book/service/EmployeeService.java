package com.example.elasticsearch.book.service;

import com.example.elasticsearch.book.model.Employee;

import java.util.List;

public interface EmployeeService {
    void save(Employee employee);
    void delete(Employee employee);
    void update(Employee employee);
}
