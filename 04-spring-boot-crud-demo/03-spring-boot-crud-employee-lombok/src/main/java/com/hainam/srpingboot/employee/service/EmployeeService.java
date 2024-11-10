package com.hainam.srpingboot.employee.service;

import com.hainam.srpingboot.employee.model.Employee;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface EmployeeService {

    List<Employee> findAllEmployee();

    Employee findEmployeeById(int id);

    List<Employee> findEmployeeByName(String name);

    Employee saveEmployee(Employee employee);

    void deleteEmployee(int id);
}
