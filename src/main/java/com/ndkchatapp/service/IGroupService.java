package com.ndkchatapp.service;

import com.ndkchatapp.api.output.ConversationOutput;

import java.util.List;

public interface IGroupService {
    List<ConversationOutput> findConversationsByUserId(Long user_id);
}
