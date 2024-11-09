package com.hainam.srpingboot.employee.service;

import com.hainam.srpingboot.employee.dao.EmployeeDAO;
import com.hainam.srpingboot.employee.model.Employee;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {

    private final EmployeeDAO employeeDAO;

    public EmployeeService(EmployeeDAO employeeDAO) {
        this.employeeDAO = employeeDAO;
    }

    public List<Employee> findAllEmployee() {
        return employeeDAO.findAll();
    }
}
