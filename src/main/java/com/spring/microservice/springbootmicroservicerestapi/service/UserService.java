package com.spring.microservice.springbootmicroservicerestapi.service;

import com.spring.microservice.springbootmicroservicerestapi.entity.User;
import java.util.Optional;

public interface UserService {

  public User createUser(User user);

  public User getUserById(Long id);
}
