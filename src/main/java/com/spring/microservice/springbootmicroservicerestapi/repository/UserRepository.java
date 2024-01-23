package com.spring.microservice.springbootmicroservicerestapi.repository;

import com.spring.microservice.springbootmicroservicerestapi.entity.UserEntity;
import java.util.Optional;
import javax.swing.text.html.Option;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserEntity, Long> {

  Optional<UserEntity> findByEmail(String email);
}
