package com.example.recipe2.controllers;

import com.example.recipe2.models.dto.UserDTO;
import com.example.recipe2.models.entity.UserModel;
import com.example.recipe2.services.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
@AllArgsConstructor
public class UserController {

    UserService userService;

    @GetMapping
    public ResponseEntity<List<UserDTO>> getAll() {
        return new ResponseEntity<>(userService.getAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserDTO> findById(@PathVariable int id) {
        return new ResponseEntity<>(userService.getById(id), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<UserDTO> upDate(@RequestBody UserModel userModel) {
        return new ResponseEntity<>(userService.createUser(userModel), HttpStatus.OK);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<UserDTO> upDate(@PathVariable int id, @RequestBody UserModel user) {
        return new ResponseEntity<>(userService.upDateUser(id, user), HttpStatus.OK);
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<List<UserDTO>> delete(@PathVariable int id) {
        return new ResponseEntity<>(userService.deleteUser(id), HttpStatus.OK);
    }
}
