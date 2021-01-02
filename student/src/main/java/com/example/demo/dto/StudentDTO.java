package com.example.demo.dto;

import com.example.demo.model.Student;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StudentDTO {

    private int id;
    private String name;
    private int phoneNumber;

    public StudentDTO(Student student){
        this.id = student.getId();
        this.name = student.getName();
        this.phoneNumber = student.getPhoneNumber();
    }

}
