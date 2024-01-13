package com.ndkchatapp.api.output;

import com.ndkchatapp.dto.AbstractDTO;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ConversationOutput extends AbstractDTO {
    private String name;
    private String avatar;
    private Date deleteAt;
    private List<UserOutput> participants = new ArrayList<UserOutput>();

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

    public List<UserOutput> getParticipants() {
        return participants;
    }

    public void setParticipants(List<UserOutput> participants) {
        this.participants = participants;
    }
}
