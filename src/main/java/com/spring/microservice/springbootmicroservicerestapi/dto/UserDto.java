package com.spring.microservice.springbootmicroservicerestapi.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Schema(
    description = "User DTO model information"
)
public class UserDto {

  // Swagger-UI Documentation
  @Schema(
      description = "User ID"
  )
  private Long id;

  // Swagger-UI Documentation
  @Schema(
      description = "User First Name"
  )
  // first name should not be null and empty
  @NotEmpty(message = "user first name should not be null or empty")
  private String firstName;

  // Swagger-UI Documentation
  @Schema(
      description = "User Last Name"
  )
  // last name should not be null and empty
  @NotEmpty(message = "user last name should not be null or empty")
  private String lastName;

  // Swagger-UI Documentation
  @Schema(
      description = "User Email"
  )
  // email should not be null and empty & valid email
  @NotEmpty(message = "user email should not be null or empty")
  @Email(message = "Email address should be valid")
  private String email;

}
