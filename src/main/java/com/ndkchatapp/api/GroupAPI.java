package com.ndkchatapp.api;

import com.ndkchatapp.api.output.ConversationOutput;
import com.ndkchatapp.dto.GroupDTO;
import com.ndkchatapp.service.IGroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = {"*"})
public class GroupAPI {

    @Autowired
    private IGroupService groupService;
    
    @GetMapping("/api/group_chat/{userId}")
    public List<ConversationOutput> findGroupByUserId(@PathVariable("userId") Long userId) {
        return groupService.findConversationsByUserId(userId);
    }
}
