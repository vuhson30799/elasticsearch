package com.example.elasticsearch.book.controller;

import com.example.elasticsearch.book.model.Employee;
import com.example.elasticsearch.book.service.EmployeeEsService;
import com.example.elasticsearch.book.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value= "/employee")
public class EmployeeController {
    @Autowired
    EmployeeEsService employeeEsService;

    @Autowired
    EmployeeService employeeService;

    /**
     * Method to save the employees in the database.
     * @param employee
     * @return
     */
    @PostMapping(value= "/saveEmployee")
    public ResponseEntity<String> saveEmployee(@RequestBody Employee employee) {
        employeeService.save(employee);
        employeeEsService.save(employee);
        return new ResponseEntity<>("Records saved in the db.", HttpStatus.OK);
    }

    /**
     * Method to fetch all employees from the database.
     * @return
     */
    @GetMapping(value= "/getAll")
    public Iterable<Employee> getAllEmployees() {
        return employeeEsService.findAll();
    }

    /**
     * Method to fetch the employee details on the basis of designation.
     * @param designation
     * @return
     */
    @GetMapping(value= "/findByDesignation/{employee-designation}")
    public Iterable<Employee> getByDesignation(@PathVariable(name= "employee-designation") String designation) {
        return employeeEsService.findByDesignation(designation);
    }
}
