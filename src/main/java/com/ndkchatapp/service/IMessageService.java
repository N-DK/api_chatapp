package com.ndkchatapp.service;

import com.ndkchatapp.dto.MessageDTO;

public interface IMessageService {
    MessageDTO save(MessageDTO messageDTO);
}
