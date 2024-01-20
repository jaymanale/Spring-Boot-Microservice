package com.spring.microservice.springbootmicroservicerestapi.repository;

import com.spring.microservice.springbootmicroservicerestapi.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserEntity, Long> {

}
