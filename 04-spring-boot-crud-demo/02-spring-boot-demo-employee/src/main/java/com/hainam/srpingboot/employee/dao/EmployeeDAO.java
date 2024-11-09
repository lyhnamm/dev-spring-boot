package com.hainam.srpingboot.employee.dao;

import com.hainam.srpingboot.employee.model.Employee;

import java.util.List;

public interface EmployeeDAO {

    List<Employee> findAll();

    List<Employee> findByName(String theName);
}
