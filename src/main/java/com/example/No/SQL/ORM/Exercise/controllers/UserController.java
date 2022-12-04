package com.example.No.SQL.ORM.Exercise.controllers;

import com.example.No.SQL.ORM.Exercise.entities.User;
import com.example.No.SQL.ORM.Exercise.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @PostMapping("")
    public User createUser(@RequestBody User user) {
        return userRepository.save(user);
    }

    @GetMapping("/{id}")
    public Optional<User> getUser(@PathVariable String id) {
        if (userRepository.existsById(id)) {
            return userRepository.findById(id);
        } else {
            return null;
        }
    }

    @DeleteMapping("/{id}")
    public String deleteUser(@PathVariable String id) {
        if (userRepository.existsById(id)) {
            userRepository.deleteById(id);
            return "User with id number: " + "'" + id + "'" + " is been deleted";
        }else {
            return "There's no User with this id number: " + "'" + id + "'";
        }
    }
}