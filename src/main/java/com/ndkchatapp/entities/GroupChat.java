package com.ndkchatapp.entities;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "group_chat")
public class GroupChat extends BaseEntity {

    @Column(name = "left_datetime")
    private Date leftDatetime;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "conversation_id")
    private Conversation conversation;

    public Date getLeftDatetime() {
        return leftDatetime;
    }

    public void setLeftDatetime(Date leftDatetime) {
        this.leftDatetime = leftDatetime;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Conversation getConversation() {
        return conversation;
    }

    public void setConversation(Conversation conversation) {
        this.conversation = conversation;
    }
}
