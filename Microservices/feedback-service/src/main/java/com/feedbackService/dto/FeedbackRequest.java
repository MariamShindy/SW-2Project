package com.feedbackService.dto;

import java.util.Date;

public class FeedbackRequest {
    String message ;
    Date creationDate;
    int userId; // User identifier

    public FeedbackRequest(){

    }

    public FeedbackRequest(String message, Date creationDate, int userId) {
        this.message = message;
        this.creationDate = creationDate;
        this.userId = userId;
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
