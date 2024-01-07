package com.ndkchatapp.dto;

import java.util.Date;

public class ContentDTO extends AbstractDTO {
    private String text;
    private String react;
    private boolean unsent;
    private Long message_id;
    private String reply;
    private String type;
    private String attachment_thumb_url;
    private String attachment_url;
    private int status;
    private Date delete_at;

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getReact() {
        return react;
    }

    public void setReact(String react) {
        this.react = react;
    }

    public boolean isUnsent() {
        return unsent;
    }

    public void setUnsent(boolean unsent) {
        this.unsent = unsent;
    }

    public Long getMessage_id() {
        return message_id;
    }

    public void setMessage_id(Long message_id) {
        this.message_id = message_id;
    }

    public String getReply() {
        return reply;
    }

    public void setReply(String reply) {
        this.reply = reply;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getAttachment_thumb_url() {
        return attachment_thumb_url;
    }

    public void setAttachment_thumb_url(String attachment_thumb_url) {
        this.attachment_thumb_url = attachment_thumb_url;
    }

    public String getAttachment_url() {
        return attachment_url;
    }

    public void setAttachment_url(String attachment_url) {
        this.attachment_url = attachment_url;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public Date getDelete_at() {
        return delete_at;
    }

    public void setDelete_at(Date delete_at) {
        this.delete_at = delete_at;
    }
}
