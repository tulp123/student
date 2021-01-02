package com.example.demo.service;

import com.example.demo.dao.StudentDao;
import com.example.demo.exception.NotFoundException;
import com.example.demo.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StudentServiceImpl implements StudentService{


    @Autowired
    private StudentDao studentDao;

    @Override
    public List<Student> findALl() {
        return studentDao.findAll();
    }

    @Override
    public Student findById(int id) {
        List<Student> students = new ArrayList<>();
        for (Student student : students) {
            if (student.getId() == id) {
                return studentDao.findById(id);
            }
        }
        throw new NotFoundException("Tài khoản không tồn tại");
    }

    @Override
    public List<Student> findAllByCreatedDateAsc() {
        return studentDao.findAllByCreatedDateAsc();
    }

    @Override
    public List<Student> findAllByCreatedDateDesc() {
        return studentDao.findAllByCreatedDateDesc();
    }

//    @Override
//    public List<Student> findAllByNameAsc(String name) {
//        return studentDao.findAllByNameAsc(name);
//    }

    @Override
    public List<Student> findAllByNameAsc() {
        return studentDao.findALlByNameAsc();
    }


    @Override
    public List<Student> findAllByNameDesc() {
        return studentDao.findAllByNameDesc();
    }

    @Override
    public List<Student> findAllByStatus() {
        return studentDao.findAllByStatus();
    }

    @Override
    public Student save(Student student) {
        return studentDao.save(student);
    }

    @Override
    public Student findStudentByPhoneNumber(int phoneNumber) {
        return studentDao.findByPhoneNumber(phoneNumber);
    }

    @Override
    public List<Student> findUserByName(String name) {
        return studentDao.searchByName(name);
    }

    @Override
    public void deleteAll() {
        studentDao.DeleteAll();
    }

    @Override
    public Student deleteById(int id) {
        return studentDao.DeleteById(id);
    }

//    @Override
//    public void deleteById(int id) {
//        studentDao.DeleteById(id);
//    }

}
