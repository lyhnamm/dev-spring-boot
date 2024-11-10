package com.hainam.springboot.crud.employee.service;

import com.hainam.springboot.crud.employee.dao.EmployeeRepository;
import com.hainam.springboot.crud.employee.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl {

    private final EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    public Employee getEmployeeById(int id) {
        Optional<Employee> result = employeeRepository.findById(id);
        if (result.isPresent()) {
            return result.get();
        } else {
            throw new RuntimeException("Employee not found");
        }
    }

    public List<Employee> getEmployeeByName(String name) {
        return employeeRepository.findEmployeeByName(name);
    }

    public Employee saveEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    public void deleteEmployeeById(int id) {
        Employee employee = getEmployeeById(id);
        if (employee != null) {
            employeeRepository.deleteById(id);
        }
    }

}
