package com.feedbackService.model;
import jakarta.persistence.*;
import java.util.Date;

@Entity
@Table
public class Feedback {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;
    String message ;
    Date creationDate;
    int userId; // User identifier

    public Feedback(){
    }

    public Feedback(int id, String message, Date creationDate, int userId) {
        this.id = id;
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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
