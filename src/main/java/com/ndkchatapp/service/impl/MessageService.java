package com.ndkchatapp.service.impl;

import com.ndkchatapp.converter.ContentConverter;
import com.ndkchatapp.converter.MessageConverter;
import com.ndkchatapp.dto.MessageDTO;
import com.ndkchatapp.entities.Content;
import com.ndkchatapp.entities.Message;
import com.ndkchatapp.repository.ContentRepository;
import com.ndkchatapp.repository.ConversationRepository;
import com.ndkchatapp.repository.MessageRepository;
import com.ndkchatapp.service.IMessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MessageService implements IMessageService {
    @Autowired
    private MessageRepository messageRepository;

    @Autowired
    private MessageConverter messageConverter;

    @Autowired
    private ContentConverter contentConverter;

    @Autowired
    private ConversationRepository conversationRepository;

    @Autowired
    private ContentRepository contentRepository;

    @Override
    public MessageDTO save(MessageDTO messageDTO) {
        Message message = messageConverter.toEntity(messageDTO);
        message.setConversation(conversationRepository.findOneById(messageDTO.getConversation_id()));
        messageDTO.getContents().forEach(contentDTO -> {
            Content content = contentConverter.toEntity(contentDTO);
            content.setMessage(message);
            message.getContents().add(content);
            contentRepository.save(content);
        });
        messageRepository.save(message);
        return messageConverter.toDTO(message);
    }
}
