package com.example.demo.repository;

import com.example.demo.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer> {

    Student findStudentByPhoneNumber(int phoneNum);

    List<Student>findAllByName(String name);

//    List<Student> findByOrOrderByNameAsc(String name);

}
