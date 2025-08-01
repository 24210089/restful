package com.example.demo.Respository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.Domain.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}
