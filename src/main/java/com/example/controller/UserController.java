package com.example.controller;

import com.example.model.User;
import com.example.service.UserService;
import io.micronaut.http.HttpResponse;
import io.micronaut.http.MediaType;
import io.micronaut.http.annotation.*;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.validation.Valid;
import java.util.List;
@Tag(name = "USER API" )
@Controller("/api/v1")
public class UserController {
 private final UserService userService;

 private static final Logger LOGGER = LoggerFactory.getLogger(UserService.class);

 public UserController(UserService userService) {
  this.userService = userService;
 }

 @Post
 public HttpResponse<User> CreateUser(@Body @Valid User user){
      return HttpResponse.created(userService.createUser(user));//response 201 for user created successfully

 }
 @Get
 public HttpResponse<List<User>> getAllUsers(){
      return HttpResponse.ok(userService.getAllUsers());


 }


@Get("/users/{id}")

 public HttpResponse<User> getUser(@PathVariable int id ){
 return HttpResponse.ok(userService.getUser(id));
}

@Put("/users/{id}")

 public HttpResponse<User> upDateUser(@PathVariable int id ,@Body User user){
  return HttpResponse.ok(userService.updateUser(id,user));
}


@Delete("/users/{id}")

 public HttpResponse<Void> deleteUser(@PathVariable int id){

 userService.deleteUser(id);
  return HttpResponse.ok();
}
}
