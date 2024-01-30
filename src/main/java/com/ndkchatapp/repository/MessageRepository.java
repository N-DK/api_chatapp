package com.ndkchatapp.repository;

import com.ndkchatapp.entities.Message;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MessageRepository extends JpaRepository<Message, Long> {
}
