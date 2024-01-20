package com.spring.microservice.springbootmicroservicerestapi.controller;

import com.spring.microservice.springbootmicroservicerestapi.dto.UserDto;
import com.spring.microservice.springbootmicroservicerestapi.entity.UserEntity;
import com.spring.microservice.springbootmicroservicerestapi.service.UserService;
import java.util.List;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/users")
@AllArgsConstructor
public class UserController {

  private UserService userService;

  // Build create User REST API End point
  //http://localhost:8080/api/v1/users
  @PostMapping
  public ResponseEntity<UserDto> createUser(@RequestBody UserDto userDto){
    UserDto savedUserDto = userService.createUser(userDto);
    return new ResponseEntity<>(savedUserDto, HttpStatus.CREATED);
  }

  // Get User by ID
  //http://localhost:8080/api/v1/users/1
  @GetMapping("{id}")
  public ResponseEntity<UserDto> getUserById(@PathVariable("id") Long userId){
    UserDto userById = userService.getUserById(userId);
    return new ResponseEntity<>(userById, HttpStatus.OK);
  }

  // Get All Users
  //http://localhost:8080/api/v1/users
  @GetMapping
  public ResponseEntity<List<UserEntity>> getUsers(){
    List<UserEntity> users = userService.getUsers();
    return new ResponseEntity<>(users, HttpStatus.OK);
  }

  // Update existing User by ID
  //http://localhost:8080/api/v1/users/1

  @PutMapping("{id}")
  public ResponseEntity<UserEntity> updateUser(@PathVariable Long id, @RequestBody UserEntity userEntity){
    userEntity.setId(id);
    UserEntity updatedUser = userService.updateUser(userEntity);
    return new ResponseEntity<>(updatedUser, HttpStatus.OK);
  }

  // Delete existing User by ID
  //http://localhost:8080/api/v1/users/1
  @DeleteMapping("{id}")
  public ResponseEntity<String> deleteUser(@PathVariable Long id){
    String deleteMessage = userService.deleteUser(id);
    return new ResponseEntity<>(deleteMessage,HttpStatus.OK);
  }

}
