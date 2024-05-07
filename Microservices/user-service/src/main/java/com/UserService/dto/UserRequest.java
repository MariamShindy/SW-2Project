package com.UserService.dto;

import com.UserService.model.Role;

public class UserRequest {

    String fristName;
    String lastName;
    String email;
    String password ;
    Role role;
    public UserRequest(){

    }

    public UserRequest(String fristName, String lastName, String email, String password, Role role) {
        this.fristName = fristName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.role = role;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFristName() {
        return fristName;
    }

    public void setFristName(String fristName) {
        this.fristName = fristName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }
}
