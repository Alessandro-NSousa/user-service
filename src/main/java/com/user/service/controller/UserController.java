package com.user.service.controller;

import com.user.service.model.User;
import com.user.service.service.UserService;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping(path = "/v1/user")
@RequiredArgsConstructor
public class UserController {

    private final Logger log = LoggerFactory.getLogger(UserController.class);

    private final UserService userService;

    @GetMapping
    public ResponseEntity<List<User>> finAll() {

      var users = this.userService.findAll();
      return new ResponseEntity<>(users, HttpStatus.OK);
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<User> findById(@PathVariable Integer id) {

        var user = this.userService.findById(id);
        return new ResponseEntity<>(user, HttpStatus.OK);


    }

    @PutMapping(path = "/{id}")
    public ResponseEntity<User> update(@PathVariable Integer id, @RequestBody User data) {
        var user = this.userService.update(id, data);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<User> delete(@PathVariable Integer id) {
        this.userService.delete(id);
        return ResponseEntity.noContent().build();

    }
}
