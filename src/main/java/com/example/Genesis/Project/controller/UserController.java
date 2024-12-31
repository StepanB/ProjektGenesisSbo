package com.example.Genesis.Project.controller;

import com.example.Genesis.Project.model.User;
import com.example.Genesis.Project.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/users")
public class UserController {

    @Autowired
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }


    @PostMapping
    public ResponseEntity<User> addUser(@RequestBody User user) throws Exception {
        return ResponseEntity.ok(userService.addUser(user));
    }

    @GetMapping("/personId/{personId}")
    public ResponseEntity<String> getUserByPersonID(@PathVariable String personId) throws IOException {
        String result = userService.getUserByPersonID(personId);
        return ResponseEntity.ok(result);
    }


    @GetMapping
    public ResponseEntity<List<User>> getAllUsers() {
        return ResponseEntity.ok(userService.getAllUsers());
    }


    @PutMapping("/{id}")
    public ResponseEntity<User> updateUser(@PathVariable Long id, @RequestBody User user) throws Exception {
        user.setId(id);
        return ResponseEntity.ok(userService.updateUser(user));
    }


    public ResponseEntity<Void> deleteUser(@PathVariable Long id) {
        userService.deleteUser(id);
        return ResponseEntity.noContent().build();
    }


    @GetMapping("/uuid/{uuid}")
    public ResponseEntity<String> getUserByUuid(@PathVariable String uuid) {
        return ResponseEntity.ok(userService.getUserByUuid(uuid));
    }


    @GetMapping("/{id}")
    public ResponseEntity<Optional<User>> getUserById(@PathVariable Long id) {
        return ResponseEntity.ok(userService.getUserById(id));
    }
}
