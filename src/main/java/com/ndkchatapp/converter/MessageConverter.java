package com.ndkchatapp.converter;

import com.ndkchatapp.dto.MessageDTO;
import com.ndkchatapp.entities.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MessageConverter {

    @Autowired
    private ContentConverter contentConverter;

    public MessageDTO toDTO(Message message) {
        MessageDTO messageDTO = new MessageDTO();
        messageDTO.setId(message.getId());
        messageDTO.getSender_id(message.getSender_id());
        messageDTO.setConversation_id(message.getConversation().getId());
        message.getContents().forEach(content -> {
            messageDTO.getContents().add(contentConverter.toDTO(content));
        });
        return messageDTO;
    }

    public Message toEntity(MessageDTO messageDTO) {
        Message message = new Message();
        message.setSender_id(messageDTO.getSender_id(message.getSender_id()));
        return message;
    }
}
