package com.example.demo.controller;

import com.example.demo.dto.StudentDTO;
import com.example.demo.exception.NotFoundException;
import com.example.demo.model.Student;
import com.example.demo.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping({"/student"})
public class StudentController {

    @Autowired
    private StudentService studentService;

    //Get all
    @GetMapping
    public List<Student> getAllStudent() {
        return studentService.findALl();
    }

    //get all through DTO
    @GetMapping("/dto")
    public List<StudentDTO> getAllStudentByDTO() {
        List<Student> students = studentService.findALl();
        return mapDataToStudentDTO(students);
    }

    private List<StudentDTO> mapDataToStudentDTO(List<Student> students) {
        List<StudentDTO> studentDTOS = new ArrayList<>();
        for (Student student : students) {
            StudentDTO studentDTO = new StudentDTO(student);
            studentDTOS.add(studentDTO);
        }
        return studentDTOS;
    }

    //Get a single student
    @GetMapping("/{id}")
    public Student getStudentById(@PathVariable(value = "id") int id) {
        return studentService.findById(id);
    }

    //get a single student through DTO
    @GetMapping("/dto/{id}")
    public StudentDTO getStudentById(@PathVariable(value = "id") Integer id) {
        Student student = studentService.findById(id);
        return new StudentDTO(student);
    }

    //Create a student
    @PostMapping("/{id}")
    public Student saveStudent(@RequestBody Student student){
        return studentService.save(student);
    }

    //Create a student through DTO
    @PostMapping("/create")
    public StudentDTO saveStudentByDTO(@RequestBody Student student) {
        Student student1 = studentService.save(student);
        return new StudentDTO(student1);
    }

    //update
    @PutMapping("/{id}")
    public Student updateStudent(@PathVariable(value = "id") Integer studentId, @RequestBody Student studentDetail) {
        studentDetail.setId(studentId);
        Student studentUpdate = studentService.save(studentDetail);
        return studentUpdate;
    }

    //delete all
    @DeleteMapping
    public void deleteAll() {
        studentService.deleteAll();
    }

    //cách thứ 2 để xóa
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteFingerprint(@PathVariable(value = "id") int id) {
//        studentService.deleteById(id);
        try {
            studentService.deleteById(id);
//            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
//            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
//            System.out.println(e);
            e.printStackTrace();
//            new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>(HttpStatus.OK);
    }

    //delete by Id
//    @DeleteMapping("/{id}")
//    public void deleteById(@PathVariable(value = "id") int id){
//        studentService.deleteById(id);
//    }

//    @DeleteMapping("/{id}")
//    public String deleteById(@PathVariable(value = "id") int id){
//        studentService.deleteById(id);
//        return "redirect:/";
//    }

    //searchByPhoneNumber
    @GetMapping("/phoneNumber")
    public Student searchByPhoneNumber(@RequestParam int phoneNum) {
        return studentService.findStudentByPhoneNumber(phoneNum);
    }

    //searchByName
    @GetMapping("/search/{name}")
    public List<Student> searchStudentByName(@PathVariable(value = "name") String name) {
        return studentService.findUserByName(name);
    }

    //sort
//    @GetMapping("/sort-up")
//    public List<Student> getAllStudentSortUp(){
//        return studentService.findAllByCreatedDateAsc();
//    }

    @GetMapping("/dto/sort-up")
    public List<StudentDTO> getAllStudentSortUp() {
        List<Student> students = studentService.findAllByCreatedDateAsc();
        return mapToStudentDTO(students);
    }

    private List<StudentDTO> mapToStudentDTO(List<Student> students) {
        List<StudentDTO> studentDTOS = new ArrayList<>();
        for (Student student : students) {
            StudentDTO studentDTO = new StudentDTO(student);
            studentDTOS.add(studentDTO);
        }
        return studentDTOS;
    }

    @GetMapping("/sort-down")
    public List<Student> getAllStudentSortDown() {
        return studentService.findAllByCreatedDateDesc();
    }


    //sort by name
    @GetMapping("/name/up")
    public List<StudentDTO> getAllStudentSortUpByName() {
        List<Student> students = studentService.findAllByNameAsc();
        return map(students);
    }

    private List<StudentDTO> map(List<Student> students) {
        //Tạo mảng động hoặc danh sách liên kết
        List<StudentDTO> studentDTOS = new ArrayList<>();
//        List<StudentDTO> studentDTOS = new LinkedList<>();
        for (Student student : students) {
            StudentDTO studentDTO = new StudentDTO(student);
            studentDTOS.add(studentDTO);
        }
        return studentDTOS;
    }

    //sort by name up through DTO
    @GetMapping("/name/sort-up")
    public List<Student> getAllStudentDTOSortUpByName() {
        return studentService.findAllByNameAsc();
    }

    //sort by name down
    @GetMapping("/name/down")
    public List<Student> getAllStudentSortDownByName() {
        return studentService.findAllByNameDesc();
    }

    //sortByStatus
    @GetMapping("/status")
    public List<Student> getAllStudentByStatus() {
        return studentService.findAllByStatus();
    }

}
