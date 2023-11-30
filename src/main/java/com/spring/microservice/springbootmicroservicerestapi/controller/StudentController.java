package com.spring.microservice.springbootmicroservicerestapi.controller;

import com.spring.microservice.springbootmicroservicerestapi.bean.Student;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StudentController {

@GetMapping("student")
  public Student getStudent(){
    Student student = new Student(1,"jay","manale");
    return student;
  }

}
