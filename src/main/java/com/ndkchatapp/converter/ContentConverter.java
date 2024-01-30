package com.ndkchatapp.converter;

import com.ndkchatapp.dto.ContentDTO;
import com.ndkchatapp.entities.Content;
import org.springframework.stereotype.Component;

@Component
public class ContentConverter {

    public ContentDTO toDTO(Content content) {
        ContentDTO contentDTO = new ContentDTO();
        contentDTO.setId(content.getId());
        contentDTO.setMessage_id(content.getMessage().getId());
        contentDTO.setText(content.getText());
        contentDTO.setReact(content.getReact());
        contentDTO.setReact(content.getReply());
        contentDTO.setType(content.getType());
        contentDTO.setAttachment_thumb_url(content.getAttachment_thumb_url());
        contentDTO.setAttachment_url(content.getAttachment_url());
        contentDTO.setStatus(content.getStatus());
        contentDTO.setDelete_at(content.getDeleteAt());
        return contentDTO;
    }

    public Content toEntity(ContentDTO contentDTO) {
        Content content = new Content();
        content.setText(contentDTO.getText());
        content.setReact(contentDTO.getReact());
        content.setReact(contentDTO.getReply());
        content.setType(contentDTO.getType());
        content.setAttachment_thumb_url(contentDTO.getAttachment_thumb_url());
        content.setAttachment_url(contentDTO.getAttachment_url());
        content.setStatus(contentDTO.getStatus());
        content.setDeleteAt(contentDTO.getDelete_at());
        return content;
    }
}
