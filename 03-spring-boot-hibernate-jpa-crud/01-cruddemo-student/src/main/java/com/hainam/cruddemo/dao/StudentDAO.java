package com.hainam.cruddemo.dao;

import com.hainam.cruddemo.model.Student;

import java.util.List;

public interface StudentDAO {

    void save(Student student);

    Student findById(int id);

    List<Student> findAll();

    List<Student> findByLastName(String theLastName);

    void update(Student student);

    void delete(Integer id);

    int deleteAll();
}
