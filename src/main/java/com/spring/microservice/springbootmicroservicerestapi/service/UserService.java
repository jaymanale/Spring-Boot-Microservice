package com.spring.microservice.springbootmicroservicerestapi.service;

import com.spring.microservice.springbootmicroservicerestapi.dto.UserDto;
import com.spring.microservice.springbootmicroservicerestapi.entity.UserEntity;
import java.util.List;

public interface UserService {

  public UserDto createUser(UserDto userDto);

  public UserEntity getUserById(Long id);

  public List<UserEntity> getUsers();

  public UserEntity updateUser(UserEntity userEntity);

  public String deleteUser(Long id);
}
