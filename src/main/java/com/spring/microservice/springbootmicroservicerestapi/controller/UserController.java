package com.spring.microservice.springbootmicroservicerestapi.controller;

import com.spring.microservice.springbootmicroservicerestapi.dto.UserDto;
import com.spring.microservice.springbootmicroservicerestapi.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
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
@Tag(
    name = "CRUD REST API for User Resource",
    description = "create user, update user, get user, get all users, delete user"
)
public class UserController {

  private UserService userService;

 // Swagger-UI Documentation
  @Operation(
      summary = "Create User REST API",
      description = "Create User REST API is used save a user in the Database"
  )
  @ApiResponse(
      responseCode = "201",
      description = "HTTP status 201 CREATED"
  )
  // Build create User REST API End point
  //http://localhost:8080/api/v1/users
  @PostMapping
  public ResponseEntity<UserDto> createUser(@RequestBody @Valid UserDto userDto){
    UserDto savedUserDto = userService.createUser(userDto);
    return new ResponseEntity<>(savedUserDto, HttpStatus.CREATED);
  }


  // Swagger-UI Documentation
  @Operation(
      summary = "Get User by ID REST API",
      description = "Get User by ID REST API is used to get a single user from Database"
  )
  @ApiResponse(
      responseCode = "200",
      description = "HTTP status 200 SUCCESS"
  )
  // Get User by ID
  //http://localhost:8080/api/v1/users/1
  @GetMapping("{id}")
  public ResponseEntity<UserDto> getUserById(@PathVariable("id") Long userId){
    UserDto userById = userService.getUserById(userId);
    return new ResponseEntity<>(userById, HttpStatus.OK);
  }


  // Swagger-UI Documentation
  @Operation(
      summary = "Get All User REST API",
      description = "Get All User REST API is used to get all user from Database"
  )
  @ApiResponse(
      responseCode = "200",
      description = "HTTP status 200 SUCCESS"
  )
  // Get All Users
  //http://localhost:8080/api/v1/users
  @GetMapping
  public ResponseEntity<List<UserDto>> getUsers(){
    List<UserDto> users = userService.getUsers();
    return new ResponseEntity<>(users, HttpStatus.OK);
  }


  // Swagger-UI Documentation
  @Operation(
      summary = "Update User by ID REST API",
      description = "Update User REST API is used to update a particular user in the Database"
  )
  @ApiResponse(
      responseCode = "200",
      description = "HTTP status 200 SUCCESS"
  )
  // Update existing User by ID
  //http://localhost:8080/api/v1/users/1
  @PutMapping("{id}")
  public ResponseEntity<UserDto> updateUser(@PathVariable Long id, @RequestBody @Valid UserDto userDto){
    userDto.setId(id);
    UserDto updatedUser = userService.updateUser(userDto);
    return new ResponseEntity<>(updatedUser, HttpStatus.OK);
  }

 // Swagger-UI Documentation
  @Operation(
      summary = "Delete User by ID REST API",
      description = "Delete User REST API is used to delete a particular user in the Database"
  )
  @ApiResponse(
      responseCode = "200",
      description = "HTTP status 200 SUCCESS"
  )
  // Delete existing User by ID
  //http://localhost:8080/api/v1/users/1
  @DeleteMapping("{id}")
  public ResponseEntity<String> deleteUser(@PathVariable Long id){
    String deleteMessage = userService.deleteUser(id);
    return new ResponseEntity<>(deleteMessage,HttpStatus.OK);
  }


}
