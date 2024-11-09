package com.hainam.srpingboot.employee.repository;

import com.hainam.srpingboot.employee.dao.EmployeeDAO;
import com.hainam.srpingboot.employee.model.Employee;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class EmployeeDAOImpl implements EmployeeDAO {

    private final EntityManager em;

    @Autowired
    public EmployeeDAOImpl(EntityManager em) {
        this.em = em;
    }

    @Override
    public List<Employee> findAll() {
        TypedQuery<Employee> query = em.createQuery(" from Employee ", Employee.class);
        return query.getResultList();
    }

    @Override
    public Employee findById(int theId) {
        return em.find(Employee.class, theId);
    }

    @Override
    public List<Employee> findByName(String theName) {
        TypedQuery<Employee> query = em.createQuery(" from Employee where firstName like :firstName or lastName like :lastName", Employee.class);
        query.setParameter("firstName", "%" + theName + "%");
        query.setParameter("lastName", "%" + theName + "%");
        return query.getResultList();
    }
}
