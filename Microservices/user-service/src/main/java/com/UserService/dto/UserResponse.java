package com.UserService.dto;

import com.UserService.model.Role;

public class UserResponse {
    String fristName;
    String email;
    int id;
    public UserResponse(){
    }

    public UserResponse(String fristName, String email, int id) {
        this.fristName = fristName;
        this.email = email;
        this.id = id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


    public String getFristName() {
        return fristName;
    }

    public void setFristName(String fristName) {
        this.fristName = fristName;
    }


}
