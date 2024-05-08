package com.UserService.controller;

import com.UserService.dto.UserRequest;
import com.UserService.dto.UserResponse;
import com.UserService.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://127.0.0.1:5500")
@RequestMapping("/api/user")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/saveUser")
    @ResponseStatus(HttpStatus.CREATED)
    public void saveUser(@RequestBody UserRequest userRequest) {
        userService.saveUser(userRequest);
    }

    @GetMapping ("/all")
    @ResponseStatus(HttpStatus.OK)
    public List<UserResponse> getAll(){
        return userService.getAll();
    }
}
