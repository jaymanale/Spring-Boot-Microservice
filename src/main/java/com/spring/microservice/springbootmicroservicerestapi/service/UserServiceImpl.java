package com.spring.microservice.springbootmicroservicerestapi.service;

import com.spring.microservice.springbootmicroservicerestapi.entity.User;
import com.spring.microservice.springbootmicroservicerestapi.repository.UserRepository;
import java.util.List;
import java.util.Optional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {

  private UserRepository userRepository;


  @Override
  public User createUser(User user) {
    return userRepository.save(user);
  }

  @Override
  public User getUserById(Long id) {
    Optional<User> byId = userRepository.findById(id);
    return byId.orElseGet(User::new);
  }

  /**
   * @return
   */
  @Override
  public List<User> getUsers() {
    return userRepository.findAll();
  }

  /**
   * @param user
   * @return
   */
  @Override
  public User updateUser(User user) {

    Optional<User> userById = userRepository.findById(user.getId());
    User existingUser = userById.orElse(user);
    existingUser.setFirstName(user.getFirstName());
    existingUser.setLastName(user.getLastName());
    existingUser.setEmail(user.getEmail());
    return userRepository.save(existingUser);
  }

  /**
   * @param id
   * @return
   */
  @Override
  public String deleteUser(Long id) {
    userRepository.deleteById(id);
    return "User with ID : "+id +" delete successfully";
  }
}
