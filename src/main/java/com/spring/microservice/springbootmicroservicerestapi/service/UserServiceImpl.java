package com.spring.microservice.springbootmicroservicerestapi.service;

import com.spring.microservice.springbootmicroservicerestapi.dto.UserDto;
import com.spring.microservice.springbootmicroservicerestapi.entity.UserEntity;
import com.spring.microservice.springbootmicroservicerestapi.exception.ResourceNotFoundException;
import com.spring.microservice.springbootmicroservicerestapi.repository.UserRepository;
import java.util.List;
import java.util.Optional;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {

  private UserRepository userRepository;

  private ModelMapper modelMapper;


  @Override
  public UserDto createUser(UserDto userDto) {
    // Convert User DTO to User entity
    UserEntity userEntity = modelMapper.map(userDto, UserEntity.class);

    // Save user to DB
    UserEntity saveUser = userRepository.save(userEntity);

    // Convert User entity to User DTO
    return modelMapper.map(saveUser, UserDto.class);
  }

  @Override
  public UserDto getUserById(Long id) {
    UserEntity userEntity = userRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("User", "id", id));
    return modelMapper.map(userEntity, UserDto.class);
  }

  /**
   * @return
   */
  @Override
  public List<UserDto> getUsers() {
   List<UserEntity> allUsers = userRepository.findAll();
   return allUsers.stream().map(user -> modelMapper.map(user, UserDto.class)).toList();
  }

  /**
   * @param userDto
   * @return
   */
  @Override
  public UserDto updateUser(UserDto userDto) {

    UserEntity existingUser = userRepository.findById(userDto.getId()).orElseThrow(() -> new ResourceNotFoundException("User","id", userDto.getId()));
    existingUser.setFirstName(userDto.getFirstName());
    existingUser.setLastName(userDto.getLastName());
    existingUser.setEmail(userDto.getEmail());

    UserEntity saveUser = userRepository.save(existingUser);
    return modelMapper.map(saveUser, UserDto.class);
  }

  /**
   * @param id
   * @return
   */
  @Override
  public String deleteUser(Long id) {
    userRepository.findById(id).orElseThrow(() ->  new ResourceNotFoundException("User", "id", id));
    userRepository.deleteById(id);
    return "User with ID : "+id +" delete successfully";
  }
}
