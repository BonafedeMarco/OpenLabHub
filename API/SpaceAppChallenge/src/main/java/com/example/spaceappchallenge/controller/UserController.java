package com.example.spaceappchallenge.controller;

import com.example.spaceappchallenge.dto.request.CreateUserDto;
import com.example.spaceappchallenge.service.implementations.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/user")
@RestController
public class UserController {

    private final UserService userService;

    public UserController (UserService userService){
        this.userService = userService;
    }

    @GetMapping("/users")
    public ResponseEntity<?> getAll(){
        return new ResponseEntity<>(userService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/{userId}")
    public ResponseEntity<?> getAll(@PathVariable long userId){
        return new ResponseEntity<>(userService.findById(userId), HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<?> getAll(@RequestBody CreateUserDto newUser){
        return new ResponseEntity<>(userService.addUser(newUser), HttpStatus.OK);
    }

}
