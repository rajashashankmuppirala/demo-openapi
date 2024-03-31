package com.shashank.demoopenapi.controller;

import com.shashank.demoopenapi.model.User;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@RestController
public class UserController {

    List<User> users = new ArrayList<>();
    Random rand = new Random();

    @RequestMapping(
            method = RequestMethod.POST,
            value = "/user",
            produces = { "application/json" }
    )
    private ResponseEntity<Void> createUsers() {
        users.add(new User(Long.valueOf(String.valueOf(rand.nextInt(100))),"test","users"));
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @RequestMapping(
            method = RequestMethod.GET,
            value = "/user",
            produces = { "application/json" }
    )

    private ResponseEntity<List<User>> listUsers(
              @RequestParam(value = "limit", required = false) Integer limit
    ) {
        return ResponseEntity.ok(users);
    }

    @RequestMapping(
            method = RequestMethod.GET,
            value = "/user/{userId}",
            produces = { "application/json" }
    )

    private ResponseEntity<List<User>> showUserById(
            @PathVariable("userId") String userId
    ) {
        return ResponseEntity.ok(users);
    }
}
