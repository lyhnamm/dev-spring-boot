package com.hainam.springboot.crud.employee.controller;

import com.hainam.springboot.crud.employee.model.Employee;
import com.hainam.springboot.crud.employee.service.EmployeeServiceImpl;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@Tag(name = "Employees")
public class EmployeeController {

    private final EmployeeServiceImpl employeeService;

    @Autowired
    public EmployeeController(EmployeeServiceImpl employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/employees")
    @Operation(summary = "Get all employees", description = "Return a list all employees")
    public List<Employee> getAllEmployees() {
        return employeeService.getAllEmployees();
    }

    @GetMapping("/employee/{employeeId}")
    @Operation(summary = "Get an employee by specific id", description = "Return a specific employee that matched id")
    public Employee getEmployeeById(@PathVariable int employeeId) {
        return employeeService.getEmployeeById(employeeId);
    }

    @GetMapping("/employees/{employeeName}")
    @Operation(summary = "Get a list of employees has first name or last name contains keyword", description = "Return a list of employees")
    public List<Employee> getEmployeeById(@PathVariable String employeeName) {
        return employeeService.getEmployeeByName(employeeName);
    }

    @PostMapping("/employees")
    @Operation(summary = "Create a new employee", description = "Create a new employee with a form submit")
    public Employee createEmployee(@RequestBody Employee theEmployee) {
        theEmployee.setId(0);
        return employeeService.saveEmployee(theEmployee);
    }

    @PutMapping("/employees")
    @Operation(summary = "Update an existed employee", description = "Update an existed employee with given information")
    public Employee updateEmployee(@RequestBody Employee theEmployee) {
        return employeeService.saveEmployee(theEmployee);
    }

    @DeleteMapping("/employees/{employeeId}")
    @Operation(summary = "Delete an employee by id", description = "Delete an employee by id. If the employee exist, then delete it. Otherwise, throw an exception")
    public String deleteEmployee(@PathVariable int employeeId) {
        employeeService.deleteEmployeeById(employeeId);
        return "Deleted employee with id: " + employeeId;
    }
}
