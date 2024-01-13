package com.ndkchatapp.api;

import com.ndkchatapp.dto.ConversationDTO;
import com.ndkchatapp.service.IConversationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = {"*"})
public class ConversationAPI {

    @Autowired
    private IConversationService conversationService;

    @PostMapping("/api/conversation")
    public ResponseEntity<?> createConversation(@RequestBody ConversationDTO model) {
        return conversationService.save(model);
    }

}
