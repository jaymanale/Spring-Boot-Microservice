package com.spring.microservice.springbootmicroservicerestapi.mapper;

import com.spring.microservice.springbootmicroservicerestapi.dto.UserDto;
import com.spring.microservice.springbootmicroservicerestapi.entity.UserEntity;

public class UserMapper {

  public static UserDto mapToUserDto(UserEntity userEntity){

    return new UserDto(
        userEntity.getId(),
        userEntity.getFirstName(),
        userEntity.getLastName(),
        userEntity.getEmail()
    );
  }

  public static UserEntity mapToUserEntity(UserDto userDto){
    return new UserEntity(
        userDto.getId(),
        userDto.getFirstName(),
        userDto.getLastName(),
        userDto.getEmail()
    );
  }

}
