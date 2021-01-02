package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Objects;

@Entity
@Table(name="student")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "Name")
    private String name;

    @Column(name = "Age")
    private int age;

    @Column(name = "phone_number")
    private int phoneNumber;

    @Column(name = "created_date", updatable = false)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/YYYY")
    private LocalDate createdDate;

    @Column(name = "status")
    private boolean status;

    @Override
   public boolean equals(Object o){
        if(this == o) return true;
        if(!(o instanceof Student)) return false;
        Student student = (Student) o;
        return getId() == student.getId() &&
                isStatus() == student.isStatus() &&
                Objects.equals(getName(), student.getName()) &&
                Objects.equals(getAge(), student.getAge()) &&
                Objects.equals(getCreatedDate(), student.getCreatedDate()) &&
                Objects.equals(getPhoneNumber(), student.getPhoneNumber());
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
}
