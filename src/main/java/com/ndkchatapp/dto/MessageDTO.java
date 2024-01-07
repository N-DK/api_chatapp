package com.ndkchatapp.dto;

import java.util.ArrayList;
import java.util.List;

public class MessageDTO extends AbstractDTO {
    private Long sender_id;
    private Long conversation_id;
    private List<ContentDTO> contents = new ArrayList<ContentDTO>();

    public Long getSender_id() {
        return sender_id;
    }

    public void setSender_id(Long sender_id) {
        this.sender_id = sender_id;
    }

    public Long getConversation_id() {
        return conversation_id;
    }

    public void setConversation_id(Long conversation_id) {
        this.conversation_id = conversation_id;
    }

    public List<ContentDTO> getContents() {
        return contents;
    }

    public void setContents(List<ContentDTO> contents) {
        this.contents = contents;
    }
}
