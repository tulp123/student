package com.example.demo.dao;

import com.example.demo.model.Student;
import com.example.demo.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Repository
public class StudentDaoImpl implements StudentDao {

    //Dùng hibernate
    @PersistenceContext
    EntityManager entityManager;

    @Autowired
    private StudentRepository studentRepository;

    @Override
    public List<Student> findAll() {
        return studentRepository.findAll();
    }

    @Override
    public List<Student> findAllByCreatedDateAsc() {
        Query query = entityManager.createQuery("select m from Student as m order by m.createdDate asc");
        List<Student> results = query.getResultList();
        return results;
    }

    @Override
    public List<Student> findAllByCreatedDateDesc() {
        Query query = entityManager.createQuery("select n from Student as n order by n.createdDate desc");
        List<Student> results = query.getResultList();
        return results;
    }

//    @Override
//    public List<Student> findAllByNameAsc(String name) {
//        return studentRepository.findByOrOrderByNameAsc(name);
//    }

//    @Override
//    public List<Student> findALlByNameAsc(Sort sort) {
//        return studentRepository.findByOrOrderByNameAsc();
//    }

    @Override
    public List<Student> findALlByNameAsc() {
        Query query = entityManager.createQuery("select m from Student as m order by m.name asc ");
        List<Student> results = query.getResultList();
        return results;
    }


    @Override
    public List<Student> findAllByNameDesc() {
        Query query = entityManager.createQuery("select n from Student as n order by n.name desc ");
        List<Student> results = query.getResultList();
        return results;
    }

    @Override
    public List<Student> findAllByStatus() {
        Query query = entityManager.createQuery("select m from Student as m where m.status = false");
        List<Student> results = query.getResultList();
        return results;
    }

    @Override
    public Student findById(int id) {
        return studentRepository.getOne(id);
    }

    @Override
    public Student save(Student student) {
        return studentRepository.save(student);
    }

    @Override
    public Student findByPhoneNumber(int phoneNumber) {
        return studentRepository.findStudentByPhoneNumber(phoneNumber);
    }

    @Override
    public List<Student> searchByName(String name) {
        return studentRepository.findAllByName(name);
    }

    @Override
    public Student DeleteById(int id) {
        studentRepository.deleteById(id);
        return null;
    }

//    @Override
//    public ResponseEntity<Object> DeleteById(int id) {
//        studentRepository.deleteById(id);
//        try {
//            studentRepository.deleteById(id);
//            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
//        } catch (Exception e) {
//            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
//        }
//    }


//    @Override
//    public void DeleteById(int id) {
//        studentRepository.deleteById(id);
//    }

    @Override
    public void DeleteAll() {
        studentRepository.deleteAll();
    }
}
