package com.example.elasticsearch.book.service;

import com.example.elasticsearch.book.model.Employee;
import com.example.elasticsearch.book.elasticsearchRepository.EmployeeEsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeEsServiceImpl implements EmployeeEsService {
    // The dao repository will use the Elastic-Search-Repository to perform the database operations.
    @Autowired
    private EmployeeEsRepository employeeEsRepository;

    /* (non-Javadoc)
     * @see com.springboot.elasticsearch.service.Employeeserv#findAllEmployees()
     */
    @Override
    public Iterable<Employee> findAll() {
        return employeeEsRepository.findAll();
    }

    /* (non-Javadoc)
     * @see com.springboot.elasticsearch.service.Employeeserv#findByDesignation(java.lang.String)
     */
    @Override
    public List<Employee> findByDesignation(String designation) {
        return employeeEsRepository.findByDesignation(designation);
    }

    @Override
    public void save(Employee employee) {
        employeeEsRepository.save(employee);
    }

    @Override
    public void delete(Employee employee) {
        employeeEsRepository.delete(employee);
    }

    @Override
    public void update(Employee employee) {
        employeeEsRepository.save(employee);
    }
}
