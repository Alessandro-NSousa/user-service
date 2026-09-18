package com.user.service.controller;

import com.user.service.model.User;
import com.user.service.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/v1/user")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping
    public ResponseEntity<List<User>> finAll() {
        try {
          var users = this.userService.findAll();
          return new ResponseEntity<>(users, HttpStatus.OK);

        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<User> findById(@PathVariable Integer id) {
        try {
            var user = this.userService.findById(id);
            return new ResponseEntity<>(user, HttpStatus.OK);

        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping(path = "/{id}")
    public ResponseEntity<User> update(@PathVariable Integer id, @RequestBody User data) {
        try {
            var user = this.userService.update(id, data);
            return new ResponseEntity<>(user, HttpStatus.OK);

        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
