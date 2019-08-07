package com.example.elasticsearch.book.service;

import com.example.elasticsearch.book.model.Employee;
import com.example.elasticsearch.book.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class EmployeeServiceImpl implements EmployeeService {
    @Autowired
    EmployeeRepository employeeRepository;
    @Override
    public void save(Employee employee) {
        employeeRepository.save(employee);
    }

    @Override
    public void delete(Employee employee) {
        employeeRepository.delete(employee);
    }

    @Override
    public void update(Employee employee) {
        employeeRepository.save(employee);
    }
}
