package com.spring.microservice.springbootmicroservicerestapi.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {
  private Long id;

  // first name should not be null and empty
  @NotEmpty(message = "user first name should not be null or empty")
  private String firstName;

  // last name should not be null and empty
  @NotEmpty(message = "user last name should not be null or empty")
  private String lastName;

  // email should not be null and empty & valid email
  @NotEmpty(message = "user email should not be null or empty")
  @Email(message = "Email address should be valid")
  private String email;

}
