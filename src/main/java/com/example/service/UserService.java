package com.example.service;

import com.example.exception.UserNotFoundException;
import com.example.model.User;
import com.example.repository.UserRepository;
import jakarta.inject.Singleton;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.Optional;

@Singleton
public class UserService {

    private static final Logger LOGGER = LoggerFactory.getLogger(UserService.class);

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User createUser(User user) {

        LOGGER.info(user + " <=== Is the user we are saving");

        return  userRepository.save(user);

    }

    public List<User> getAllUsers() {

        List<User> users = userRepository.findAll();
        LOGGER.info(String.valueOf("list of users from db ==> "+users));

        return userRepository.findAll();


    }

    public User getUser(int id) {
        Optional<User> user = userRepository.findById(id);
        LOGGER.info(String.valueOf(" user from db ==> "+user));

        return userRepository.findById(id).orElseThrow(()->new UserNotFoundException());
    }

    public User updateUser(int id, User user) {
        User prevuser = getUser(id);
        prevuser.setName(user.getName());
        prevuser.setMobileNumber(user.getMobileNumber());
        prevuser.setEmail(user.getEmail());
        LOGGER.info(" =====> "+prevuser +" is the previous user");

        return userRepository.update(prevuser);
    }

    public void deleteUser(int id) {

        userRepository.deleteById(id);


    }
}
