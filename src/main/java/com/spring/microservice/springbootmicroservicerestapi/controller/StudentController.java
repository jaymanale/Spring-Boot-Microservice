package com.spring.microservice.springbootmicroservicerestapi.controller;

import com.spring.microservice.springbootmicroservicerestapi.bean.Student;
import java.util.ArrayList;
import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StudentController {

  //http://localhost:8080/student
@GetMapping("student")
  public Student getStudent(){
    Student student = new Student(1,"jay","manale");
    return student;
  }

  //http://localhost:8080/students
  @GetMapping("students")
  public List<Student> getStudentList() {
    List<Student> studentList = new ArrayList<>();
    studentList.add(new Student(1,"sam","Alter"));
    studentList.add(new Student(2,"kumar","sharma"));
    studentList.add(new Student(3,"jay","manale"));

    return studentList;
  }
}
