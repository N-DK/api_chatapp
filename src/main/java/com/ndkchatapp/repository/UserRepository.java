package com.ndkchatapp.repository;

import com.ndkchatapp.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    User findOneByPhoneNumber(String phoneNumber);
    User findOneById(Long id);
}
