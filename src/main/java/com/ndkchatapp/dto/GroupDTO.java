package com.ndkchatapp.dto;

import java.util.Date;

public class GroupDTO extends AbstractDTO {
    private Long user_id;
    private Long conversation_id;
    private Date leftDatetime;

    public Long getUser_id() {
        return user_id;
    }

    public void setUser_id(Long user_id) {
        this.user_id = user_id;
    }

    public Long getConversation_id() {
        return conversation_id;
    }

    public void setConversation_id(Long conversation_id) {
        this.conversation_id = conversation_id;
    }

    public Date getLeftDatetime() {
        return leftDatetime;
    }

    public void setLeftDatetime(Date leftDatetime) {
        this.leftDatetime = leftDatetime;
    }
}
