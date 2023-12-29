package com.spring.microservice.springbootmicroservicerestapi.controller;

import com.spring.microservice.springbootmicroservicerestapi.bean.Student;
import java.util.ArrayList;
import java.util.List;
import org.apache.coyote.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("students")
public class StudentController {
  // Get a Student data
  //http://localhost:8080/student
@GetMapping("student")
  public ResponseEntity<Student> getStudent(){
    Student student = new Student(1,"jay","manale");

// Both statement below are same only
    return new ResponseEntity<>(student, HttpStatus.OK);
    //return ResponseEntity.ok().header("name","jay").body(student);
  }
  // Get List Of Students
  //http://localhost:8080/students
  @GetMapping
  public ResponseEntity<List<Student>> getStudentList() {
    List<Student> studentList = new ArrayList<>();
    studentList.add(new Student(1,"sam","Alter"));
    studentList.add(new Student(2,"kumar","sharma"));
    studentList.add(new Student(3,"jay","manale"));

    return new ResponseEntity<>(studentList, HttpStatus.OK);
  }

  // Get Student information based on PathVariable info
  //http://localhost:8080/students/1

  @GetMapping("{id}/{first-name}/{last-name}")
  public ResponseEntity<Student> getPathVariableStudent(@PathVariable int id, @PathVariable("first-name") String firstName, @PathVariable("last-name") String lastName){
  Student studentObj = new Student();
  studentObj.setId(id);
  studentObj.setFirstName(firstName);
  studentObj.setLastName(lastName);
  return new ResponseEntity<>(studentObj, HttpStatus.OK);
  }

  // Get Student information based on RequestParam info
  //http://localhost:8080/students/query?id=1

  @GetMapping("query")
  public ResponseEntity<Student> getStudentByRequestParam(@RequestParam int id){
    Student studentObj = new Student();
    studentObj.setId(id);
    studentObj.setFirstName("sam");
    studentObj.setLastName("karan");
  return new ResponseEntity<>(studentObj, HttpStatus.OK);
  }

  // Spring Boot REST API  -  PostRequest
  //http://localhost:8080/students/create

  @PostMapping("create")
  public ResponseEntity<Student> createStudent(@RequestBody Student student){
    System.out.println(student.getId());
    System.out.println(student.getFirstName());
    System.out.println(student.getLastName());
    return new ResponseEntity<>(student, HttpStatus.CREATED);
  }

  // Spring Boot REST API  -  PutRequest -> Update existing resource
  //http://localhost:8080/students/{id}/update

  @PutMapping("{id}/update")
  public ResponseEntity<Student> updateStudent(@RequestBody Student student, @PathVariable("id") int studentId){
    System.out.println("Updated Student Id "+ studentId);
    System.out.println(student.getLastName());
    System.out.println(student.getId());
    System.out.println(student.getFirstName());
    return new ResponseEntity<>(student, HttpStatus.OK);
  }

  // Spring Boot REST API  -  Delete -> Delete existing resource
  //http://localhost:8080/students/{id}/delete

  @DeleteMapping("{id}/delete")
  public ResponseEntity<String> deleteStudent(@PathVariable("id") int studentId){
  return ResponseEntity.ok("Student with ID : "+studentId + " deleted successfully");
  }

}
