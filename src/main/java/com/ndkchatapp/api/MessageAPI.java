package com.ndkchatapp.api;

import com.ndkchatapp.dto.MessageDTO;
import com.ndkchatapp.service.IMessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = {"*"})
public class MessageAPI {

    @Autowired
    IMessageService messageService;

    @PostMapping("/api/message")
    public MessageDTO sendMessage(@RequestBody MessageDTO model) {
        return messageService.save(model);
    }

}
