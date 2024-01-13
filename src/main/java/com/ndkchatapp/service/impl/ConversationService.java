package com.ndkchatapp.service.impl;

import com.ndkchatapp.converter.ConversationConverter;
import com.ndkchatapp.dto.ConversationDTO;
import com.ndkchatapp.entities.Conversation;
import com.ndkchatapp.entities.GroupChat;
import com.ndkchatapp.repository.ConversationRepository;
import com.ndkchatapp.repository.UserRepository;
import com.ndkchatapp.service.IConversationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class ConversationService implements IConversationService {

    @Autowired
    private ConversationConverter conversationConverter;

    @Autowired
    private ConversationRepository conversationRepository;

    @Autowired
    private UserRepository userRepository;

    @Override
    public ResponseEntity<?> save(ConversationDTO model) {
        Conversation conversation = conversationConverter.toEntity(model);
        for (Long participant : model.getParticipants()) {
            GroupChat groupChat = new GroupChat();
            groupChat.setUser(userRepository.findOneById(participant));
            groupChat.setConversation(conversation);
            conversation.getGroupChats().add(groupChat);
        }
        conversationRepository.save(conversation);
        return ResponseEntity.ok(conversationConverter.toOutput(conversation));
    }
}
