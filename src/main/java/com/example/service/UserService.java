package com.example.service;

import com.example.exception.UserNotFoundException;
import com.example.model.User;
import com.example.repository.UserRepository;
import jakarta.inject.Singleton;

import java.util.List;

@Singleton
public class UserService {



    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User createUser(User user) {

        return  userRepository.save(user);

    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public User getUser(int id) {


        return userRepository.findById(id).orElseThrow(()->new UserNotFoundException());
    }

    public User updateUser(int id, User user) {
        User prevuser = getUser(id);
        prevuser.setName(user.getName());
        prevuser.setMobileNumber(user.getMobileNumber());
        prevuser.setEmail(user.getEmail());

        return userRepository.update(prevuser);
    }

    public void deleteUser(int id) {

        userRepository.deleteById(id);


    }
}
