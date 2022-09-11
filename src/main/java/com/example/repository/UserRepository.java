package com.example.repository;

import com.example.model.User;
import com.example.service.UserService;
import io.micronaut.data.annotation.Repository;
import io.micronaut.data.repository.CrudRepository;

import java.util.List;

@Repository
public interface UserRepository extends CrudRepository<User,Integer> {

List<User> findAll();
}
