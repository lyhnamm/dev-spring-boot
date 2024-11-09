package com.hainam.srpingboot.employee.controller;

import com.hainam.srpingboot.employee.model.Employee;
import com.hainam.srpingboot.employee.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class EmployeeController {

    private final EmployeeService employeeService;

    @Autowired
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/employees")
    public List<Employee> getAllEmployees() {
        return employeeService.findAllEmployee();
    }

    @GetMapping("/employee/{id}")
    public Employee getEmployeeById(@PathVariable int id) {
        return employeeService.findEmployeeById(id);
    }

    @GetMapping("/employees/{employeeName}")
    public List<Employee> getEmployeeByName(@PathVariable String employeeName) {
        return employeeService.findEmployeeByName(employeeName);
    }
}
