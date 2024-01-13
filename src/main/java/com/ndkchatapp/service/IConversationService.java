package com.ndkchatapp.service;

import com.ndkchatapp.dto.ConversationDTO;
import org.springframework.http.ResponseEntity;

public interface IConversationService {
    ResponseEntity save(ConversationDTO model);
}
