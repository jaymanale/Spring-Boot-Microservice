package com.spring.microservice.springbootmicroservicerestapi.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {
  private Long id;
  private String firstName;
  private String lastName;
  private String email;

}
