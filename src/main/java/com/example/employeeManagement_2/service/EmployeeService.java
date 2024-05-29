package com.example.employeeManagement_2.service;

import com.example.employeeManagement_2.model.Employee;
import com.example.employeeManagement_2.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    public Employee createEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    public Optional<Employee> getEmployeeById(String id) {
        return employeeRepository.findById(id);
    }

    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    public Employee updateEmployee(String id, Employee employeeDetails) {
        Optional<Employee> optionalEmployee = employeeRepository.findById(id);
        if (optionalEmployee.isPresent()) {
            Employee employee = optionalEmployee.get();
            employee.setName(employeeDetails.getName());
            employee.setAge(employeeDetails.getAge());
            employee.setEmployeeId(employeeDetails.getEmployeeId());
            employee.setSalary(employeeDetails.getSalary());
            employee.setDateOfJoining(employeeDetails.getDateOfJoining());
            return employeeRepository.save(employee);
        } else {
            return null;
        }
    }

    public void deleteEmployee(String id) {
        employeeRepository.deleteById(id);
    }
}
