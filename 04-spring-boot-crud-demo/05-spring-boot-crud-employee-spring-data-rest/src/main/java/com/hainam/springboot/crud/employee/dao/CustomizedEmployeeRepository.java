package com.hainam.springboot.crud.employee.dao;

import com.hainam.springboot.crud.employee.model.Employee;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CustomizedEmployeeRepository {

    @Query(" from Employee where firstName like %:name% or lastName like %:name% ")
    List<Employee> findByName(@Param("name") String name);
}
