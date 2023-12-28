package com.spring.microservice.springbootmicroservicerestapi.controller;

import com.spring.microservice.springbootmicroservicerestapi.bean.Student;
import java.util.ArrayList;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
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

  // Spring Boot REST API  -  PostRequest
  //http://localhost:8080/students/create

  @PostMapping("students/create")
  @ResponseStatus(HttpStatus.CREATED)
  public Student createStudent(@RequestBody Student student){
    System.out.println(student.getId());
    System.out.println(student.getFirstName());
    System.out.println(student.getLastName());
    return  student;
  }

  // Spring Boot REST API  -  PutRequest -> Update existing resource
  //http://localhost:8080/students/{id}/update

  @PutMapping("students/{id}/update")
  public Student updateStudent(@RequestBody Student student, @PathVariable("id") int studentId){
    System.out.println("Updated Student Id "+ studentId);
    System.out.println(student.getLastName());
    System.out.println(student.getId());
    System.out.println(student.getFirstName());
    return student;
  }

  // Spring Boot REST API  -  Delete -> Delete existing resource
  //http://localhost:8080/students/{id}/delete

  @DeleteMapping("students/{id}/delete")
  public String deleteStudent(@PathVariable("id") int studentId){
  return "Student with ID : "+studentId + " deleted successfully";
  }

}
