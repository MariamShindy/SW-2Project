package com.feedbackService.dto;

import java.util.Date;

public class FeedbackResponse {
    int id;
    String message ;
    Date creationDate;
    int userId; // User identifier

    public FeedbackResponse(){

    }

    public FeedbackResponse(int id, String message, Date creationDate, int userId) {
        this.id=id;
        this.message = message;
        this.creationDate = creationDate;
        this.userId = userId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }
}