package com.example.elasticsearch.book.elasticsearchRepository;

import com.example.elasticsearch.book.model.Employee;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeEsRepository extends ElasticsearchRepository<Employee, Long> {

    /**
     * Method to fetch the employee details on the basis of designation by using Elastic-Search-Repository.
     * @param designation
     * @return
     */
    List<Employee> findByDesignation(String designation);

}
