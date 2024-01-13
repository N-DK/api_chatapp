package com.ndkchatapp.converter;

import com.ndkchatapp.api.output.ConversationOutput;
import com.ndkchatapp.api.output.UserOutput;
import com.ndkchatapp.dto.ConversationDTO;
import com.ndkchatapp.entities.Conversation;
import com.ndkchatapp.entities.GroupChat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ConversationConverter {

    @Autowired
    private UserConverter userConverter;

    public ConversationDTO toDTO(Conversation conversation) {
        ConversationDTO conversationDTO = new ConversationDTO();
        conversationDTO.setName(conversation.getName());
        conversationDTO.setAvatar(conversation.getAvatar());
        conversationDTO.setId(conversation.getId());
        conversationDTO.setCreateDate(conversation.getCreateDate());
        return conversationDTO;
    }

    public Conversation toEntity(ConversationDTO conversationDTO) {
        Conversation conversation = new Conversation();
        conversation.setName(conversationDTO.getName());
        conversation.setAvatar(conversationDTO.getAvatar());
        return conversation;
    }

    public ConversationOutput toOutput(Conversation conversation) {
        List<UserOutput> participants = new ArrayList<>();
        ConversationOutput conversationOutput = new ConversationOutput();
        conversationOutput.setName(conversation.getName());
        conversationOutput.setAvatar(conversation.getAvatar());
        conversationOutput.setId(conversation.getId());
        conversationOutput.setCreateDate(conversation.getCreateDate());
        for (GroupChat groupChat : conversation.getGroupChats()) {
            participants.add(userConverter.toOutput(groupChat.getUser()));
        }
        conversationOutput.setParticipants(participants);
        return conversationOutput;
    }
}
