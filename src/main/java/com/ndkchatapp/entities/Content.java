package com.ndkchatapp.entities;

import com.ndkchatapp.dto.MessageDTO;

import javax.persistence.*;

import java.util.Date;

@Entity
@Table(name = "content")
public class Content extends BaseEntity {

    @Column
    @Lob
    private String text;

    @Column
    private String react;

    @Column
    private boolean unsent;

    @Column
    private String type;

    @Column
    private String attachment_thumb_url;

    @Column
    @Lob
    private String reply;

    @Column
    private String attachment_url;

    @Column
    private int status;

    @Column(name = "delete_at")
    private Date deleteAt;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "message_id")
    private Message message;

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

    public Message getMessage() {
        return message;
    }

    public void setMessage(Message message) {
        this.message = message;
    }

    public boolean isUnsent() {
        return unsent;
    }

    public void setUnsent(boolean unsent) {
        this.unsent = unsent;
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

    public Date getDeleteAt() {
        return deleteAt;
    }

    public void setDeleteAt(Date deleteAt) {
        this.deleteAt = deleteAt;
    }

    public String getReply() {
        return reply;
    }

    public void setReply(String reply) {
        this.reply = reply;
    }
}
