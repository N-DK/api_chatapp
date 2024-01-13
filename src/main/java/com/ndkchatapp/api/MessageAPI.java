package com.ndkchatapp.api;

import com.ndkchatapp.dto.MessageDTO;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = {"*"})
public class MessageAPI {

    @PostMapping("/api/message")
    public MessageDTO sendMessage() {
        return null;
    }

}
