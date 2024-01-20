package com.spring.microservice.springbootmicroservicerestapi.service;

import com.spring.microservice.springbootmicroservicerestapi.DTO.UserDto;
import com.spring.microservice.springbootmicroservicerestapi.entity.User;
import java.util.List;

public interface UserService {

  public UserDto createUser(UserDto userDto);

  public User getUserById(Long id);

  public List<User> getUsers();

  public User updateUser(User user);

  public String deleteUser(Long id);
}
