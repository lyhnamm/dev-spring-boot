package com.hainam.springboot.crud.employee.dao;

import com.hainam.springboot.crud.employee.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer>, CustomizedEmployeeRepository {
    // no need to code in case of only use default methods of JpaRepository

}
