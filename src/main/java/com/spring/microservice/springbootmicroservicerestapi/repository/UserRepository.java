package com.spring.microservice.springbootmicroservicerestapi.repository;

import com.spring.microservice.springbootmicroservicerestapi.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

}
