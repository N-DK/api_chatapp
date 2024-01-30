package com.ndkchatapp.repository;

import com.ndkchatapp.entities.Content;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContentRepository extends JpaRepository<Content, Long> {
}
