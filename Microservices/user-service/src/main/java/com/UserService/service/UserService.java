package com.UserService.service;
import com.UserService.dto.UserRequest;
import com.UserService.model.Role;
import com.UserService.model.User;
import com.UserService.repository.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.logging.Logger;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    private static final Logger logger = Logger.getLogger(UserService.class.getName());

    @Transactional
    public void saveUser(UserRequest userRequest) {
        User user = mapUserRequestToUser(userRequest);
        userRepository.save(user);
        logger.info("User saved successfully");
    }

    //UserRequest ==> User
    public User mapUserRequestToUser(UserRequest userRequest){
        User user = new User();
        user.setFristName(userRequest.getFristName());
        user.setLastName(userRequest.getLastName());
        user.setEmail(userRequest.getEmail());
        user.setPassword(userRequest.getPassword());
        user.setRole(Role.Customer);
        return user;
    }

}
