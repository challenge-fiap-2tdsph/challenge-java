package com.grupo.challenge_java.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.grupo.challenge_java.model.User;


public interface UserRepository extends JpaRepository<User, Long>{

}
