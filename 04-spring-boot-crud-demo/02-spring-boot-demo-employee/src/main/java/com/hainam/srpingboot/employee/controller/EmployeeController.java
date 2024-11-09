package com.hainam.srpingboot.employee.controller;

import com.hainam.srpingboot.employee.model.Employee;
import com.hainam.srpingboot.employee.service.EmployeeService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@Tag(name = "Employees")
public class EmployeeController {

    private final EmployeeService employeeService;

    @Autowired
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/employees")
    @Operation(summary = "Get all employees", description = "Return a list all employees")
    public List<Employee> getAllEmployees() {
        return employeeService.findAllEmployee();
    }

    @GetMapping("/employee/{employeeId}")
    @Operation(summary = "Get an employee by specific id", description = "Return an employee that matched id")
    public Employee getEmployeeById(@PathVariable int employeeId) {
        return employeeService.findEmployeeById(employeeId);
    }

    @GetMapping("/employees/{employeeName}")
    @Operation(summary = "Get a list of employees has first name or last name contains keyword", description = "Return a list of employees")
    public List<Employee> getEmployeeByName(@PathVariable String employeeName) {
        return employeeService.findEmployeeByName(employeeName);
    }

    @PostMapping("/employees")
    @Operation(summary = "Create a new employee", description = "Create a new employee with a form submit")
    public Employee addEmployee(@RequestBody Employee theEmployee) {
        theEmployee.setId(0);
        return employeeService.saveEmployee(theEmployee);
    }

    @PutMapping("/employees")
    @Operation(summary = "Update an existed employee", description = "Update an existed employee with given information")
    public Employee updateEmployee(@RequestBody Employee theEmployee) {
        employeeService.saveEmployee(theEmployee);
        return theEmployee;
    }

    @DeleteMapping("/employees/{employeeId}")
    @Operation(summary = "Delete an employee by id", description = "Delete an employee by id. If the employee exist, then delete it. Otherwise, throw an exception")
    public String deleteEmployee(@PathVariable int employeeId) {
        Employee employee = employeeService.findEmployeeById(employeeId);
        if (employee == null) {
            throw new RuntimeException("Not found employeeId: " + employeeId);
        }
        employeeService.deleteEmployee(employeeId);
        return "Deleted employeeId: " + employeeId;
    }
}
