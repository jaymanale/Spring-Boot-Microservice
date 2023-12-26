package com.spring.microservice.springbootmicroservicerestapi.controller;

import com.spring.microservice.springbootmicroservicerestapi.bean.Student;
import java.util.ArrayList;
import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StudentController {
  // Get a Student data
  //http://localhost:8080/student
@GetMapping("student")
  public Student getStudent(){
    Student student = new Student(1,"jay","manale");
    return student;
  }
  // Get List Of Students
  //http://localhost:8080/students
  @GetMapping("students")
  public List<Student> getStudentList() {
    List<Student> studentList = new ArrayList<>();
    studentList.add(new Student(1,"sam","Alter"));
    studentList.add(new Student(2,"kumar","sharma"));
    studentList.add(new Student(3,"jay","manale"));

    return studentList;
  }

  // Get Student information based on PathVariable info
  //http://localhost:8080/students/1

  @GetMapping("students/{id}/{first-name}/{last-name}")
  public Student getPathVariableStudent(@PathVariable int id, @PathVariable("first-name") String firstName, @PathVariable("last-name") String lastName){
  return new Student(id,firstName,lastName);
  }

  // Get Student information based on RequestParam info
  //http://localhost:8080/students/query?id=1

  @GetMapping("students/query")
  public Student getStudentByRequestParam(@RequestParam int id){
  return new Student(id,"sam","karan");
  }

}
