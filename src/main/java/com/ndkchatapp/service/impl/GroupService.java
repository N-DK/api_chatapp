package com.ndkchatapp.service.impl;

import com.ndkchatapp.api.output.ConversationOutput;
import com.ndkchatapp.converter.ConversationConverter;
import com.ndkchatapp.entities.GroupChat;
import com.ndkchatapp.repository.GroupRepository;
import com.ndkchatapp.service.IGroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class GroupService implements IGroupService {

    @Autowired
    private GroupRepository groupRepository;

    @Autowired
    private ConversationConverter conversationConverter;

    @Override
    public List<ConversationOutput> findConversationsByUserId(Long user_id) {
        List<GroupChat> groupChats = groupRepository.findAllByUserId(user_id);
        List<ConversationOutput> results = new ArrayList<>();
        for (GroupChat groupChat : groupChats) {
            results.add(conversationConverter.toOutput(groupChat.getConversation()));
        }
        return results;
    }
}
