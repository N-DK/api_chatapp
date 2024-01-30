package com.ndkchatapp.api;

import com.ndkchatapp.api.output.ConversationOutput;
import com.ndkchatapp.dto.ConversationDTO;
import com.ndkchatapp.service.IConversationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = {"*"})
public class ConversationAPI {

    @Autowired
    private IConversationService conversationService;

    @PostMapping("/api/conversation")
    public ResponseEntity<?> createConversation(@RequestBody ConversationDTO model) {
        return conversationService.save(model);
    }

    @GetMapping("/api/conversation/{id}")
    public ConversationOutput findOneById(@PathVariable("id") Long id) {
        return conversationService.findOneById(id);
    }

}
