package com.example.demo.dao;

import com.example.demo.model.Student;

import java.util.List;

public interface StudentDao {

    List<Student> findAll();

    List<Student> findAllByCreatedDateAsc();

    List<Student> findAllByCreatedDateDesc();

    List<Student> findALlByNameAsc();

//    List<Student> findAllByNameAsc(String name);

    List<Student> findAllByNameDesc();

    List<Student> findAllByStatus();

    Student findById(int id);

    Student save(Student student);

    Student findByPhoneNumber(int phoneNumber);

    List<Student> searchByName(String name);

//    ResponseEntity<Object> DeleteById(int id);

//    void DeleteById(int id);

    Student DeleteById(int id);

    void DeleteAll();
}
