package com.example.demo.service;

import com.example.demo.dto.StudentDTO;
import com.example.demo.model.Student;

import java.util.List;

public interface StudentService {

    List<Student> findALl();

    Student findById(int id);

    List<Student> findAllByCreatedDateAsc();

    List<Student> findAllByCreatedDateDesc();

    List<Student> findAllByNameAsc();

//    List<Student> findAllByNameAsc(String name);

    List<Student> findAllByNameDesc();

    List<Student> findAllByStatus();

    Student save(Student student);

    Student findStudentByPhoneNumber(int phoneNumber);

    List<Student> findUserByName(String name);

    void deleteAll();

//    void deleteById(int id);

    Student deleteById(int id);

}
