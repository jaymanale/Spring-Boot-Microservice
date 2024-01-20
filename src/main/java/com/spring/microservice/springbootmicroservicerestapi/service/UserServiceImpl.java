package com.spring.microservice.springbootmicroservicerestapi.service;

import com.spring.microservice.springbootmicroservicerestapi.dto.UserDto;
import com.spring.microservice.springbootmicroservicerestapi.entity.UserEntity;
import com.spring.microservice.springbootmicroservicerestapi.mapper.UserMapper;
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
  public UserDto createUser(UserDto userDto) {
    // Convert User DTO to User entity
    UserEntity userEntity = UserMapper.mapToUserEntity(userDto);

    // Save user to DB
    UserEntity saveUser = userRepository.save(userEntity);

    // Convert User entity to User DTO
    return UserMapper.mapToUserDto(saveUser);
  }

  @Override
  public UserDto getUserById(Long id) {
    Optional<UserEntity> userById = userRepository.findById(id);
    UserEntity userEntity = userById.orElseGet(UserEntity::new);
    return UserMapper.mapToUserDto(userEntity);
  }

  /**
   * @return
   */
  @Override
  public List<UserDto> getUsers() {
   List<UserEntity> allUsers = userRepository.findAll();
   return allUsers.stream().map(UserMapper::mapToUserDto).toList();
  }

  /**
   * @param userDto
   * @return
   */
  @Override
  public UserDto updateUser(UserDto userDto) {

    UserEntity existingUser = userRepository.findById(userDto.getId()).get();
    existingUser.setFirstName(userDto.getFirstName());
    existingUser.setLastName(userDto.getLastName());
    existingUser.setEmail(userDto.getEmail());

    UserEntity saveUser = userRepository.save(existingUser);
    return UserMapper.mapToUserDto(saveUser);
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
