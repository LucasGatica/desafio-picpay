package com.gatica.desafio.picpay.controller;

import com.gatica.desafio.picpay.model.User;
import com.gatica.desafio.picpay.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
@AllArgsConstructor
public class UserController {

    private UserService userService;

    @PostMapping
    public User createUser(@RequestBody User user){
        return userService.addUser(user);
    }

    @GetMapping("/list")
    public List<User> listUsers(){
        return userService.listUsers();

    }
}
