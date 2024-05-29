package com.example.employeeManagement_2.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.employeeManagement_2.model.Employee;

public interface EmployeeRepository extends MongoRepository<Employee, String>{

}
