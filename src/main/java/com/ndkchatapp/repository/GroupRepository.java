package com.ndkchatapp.repository;

import com.ndkchatapp.entities.GroupChat;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface GroupRepository extends JpaRepository<GroupChat, Long> {
    List<GroupChat> findAllByUserId(Long userId);
}
