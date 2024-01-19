package com.spring.microservice.springbootmicroservicerestapi.controller;

import com.spring.microservice.springbootmicroservicerestapi.entity.User;
import com.spring.microservice.springbootmicroservicerestapi.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/users")
@AllArgsConstructor
public class UserController {

  private UserService userService;

  // Build create User REST API End point
  //http://localhost:8080/api/v1/users
  @PostMapping
  public ResponseEntity<User> createUser(@RequestBody User user){
    User savedUser = userService.createUser(user);
    return new ResponseEntity<>(savedUser, HttpStatus.CREATED);
  }

  // Get User by ID
  //http://localhost:8080/api/v1/users/1
  @GetMapping("{id}")
  public ResponseEntity<User> getUserById(@PathVariable("id") Long userId){
    User userById = userService.getUserById(userId);
    return new ResponseEntity<>(userById, HttpStatus.OK);
  }
}
