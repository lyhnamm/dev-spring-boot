package com.hainam.srpingboot.employee.service;

import com.hainam.srpingboot.employee.dao.EmployeeDAO;
import com.hainam.srpingboot.employee.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeDAO employeeDAO;

    @Autowired
    public EmployeeServiceImpl(EmployeeDAO employeeDAO) {
        this.employeeDAO = employeeDAO;
    }

    @Override
    public List<Employee> findAllEmployee() {
        return employeeDAO.findAll();
    }

    @Override
    public Employee findEmployeeById(int id) {
        return employeeDAO.findById(id);
    }

    @Override
    public List<Employee> findEmployeeByName(String name) {
        return employeeDAO.findByName(name);
    }

    @Override
    @Transactional
    public Employee saveEmployee(Employee employee) {
        return employeeDAO.save(employee);
    }

    @Override
    @Transactional
    public void deleteEmployee(int id) {
        employeeDAO.delete(id);
    }


}
