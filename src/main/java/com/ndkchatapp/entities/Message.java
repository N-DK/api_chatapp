package com.ndkchatapp.entities;

import javax.persistence.*;

import java.util.List;

@Entity
@Table(name = "message")
public class Message extends BaseEntity {

    @Column
    private Long sender_id;


    @OneToMany(mappedBy = "message")
    private List<Content> contents;

    @ManyToOne
    @JoinColumn(name = "conversation_id")
    private Conversation conversation;

    public Long getSender_id() {
        return sender_id;
    }

    public void setSender_id(Long sender_id) {
        this.sender_id = sender_id;
    }

    public List<Content> getContents() {
        return contents;
    }

    public void setContents(List<Content> contents) {
        this.contents = contents;
    }

    public Conversation getConversation() {
        return conversation;
    }

    public void setConversation(Conversation conversation) {
        this.conversation = conversation;
    }
    
}
