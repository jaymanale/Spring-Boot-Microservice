package com.spring.microservice.springbootmicroservicerestapi.service;

import com.spring.microservice.springbootmicroservicerestapi.dto.UserDto;
import com.spring.microservice.springbootmicroservicerestapi.entity.UserEntity;
import java.util.List;

public interface UserService {

  public UserDto createUser(UserDto userDto);

  public UserDto getUserById(Long id);

  public List<UserDto> getUsers();

  public UserDto updateUser(UserDto userDto);

  public String deleteUser(Long id);
}
