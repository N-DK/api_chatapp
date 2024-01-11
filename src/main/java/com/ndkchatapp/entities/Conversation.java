package com.ndkchatapp.entities;

import javax.persistence.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "conversation")
public class Conversation extends BaseEntity {

    @Column
    private String name;

    @Column
    private String avatar;

    @Column(name = "delete_at")
    private Date deleteAt;

    @OneToMany(mappedBy = "conversation")
    private List<GroupChat> groupChats = new ArrayList<GroupChat>();

    @OneToMany(mappedBy = "conversation")
    private List<Message> messages = new ArrayList<Message>();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public Date getDeleteAt() {
        return deleteAt;
    }

    public void setDeleteAt(Date deleteAt) {
        this.deleteAt = deleteAt;
    }

    public List<GroupChat> getGroupChats() {
        return groupChats;
    }

    public void setGroupChats(List<GroupChat> groupChats) {
        this.groupChats = groupChats;
    }

    public List<Message> getMessages() {
        return messages;
    }

    public void setMessages(List<Message> messages) {
        this.messages = messages;
    }
}
