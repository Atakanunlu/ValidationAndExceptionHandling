package com.atakanunlu.controller;

import com.atakanunlu.dto.UserDto;
import com.atakanunlu.entity.User;
import com.atakanunlu.exception.UserNotFoundException;
import com.atakanunlu.mapper.UserMapper;
import com.atakanunlu.resource.UserResource;
import com.atakanunlu.service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
@CrossOrigin("http://localhost:4200/")
public class UserController {

    private final UserService userService;
    private final UserMapper userMapper;

    @PostMapping("/save")
    public ResponseEntity<UserResource> saveUser(@RequestBody @Valid UserDto userDto) {
        User user = userService.saveUser(userMapper.toEntity(userDto));
        return ResponseEntity.ok(userMapper.toResource(user));
    }

    @GetMapping("/all")
    public List<UserResource> getAllUsers(@RequestParam(required = false) String sortByAge) {
        List<User> userResources = userService.getAllUsersSortedByAge(sortByAge);
        return userMapper.toResource(userResources);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserResource> getUserById(@PathVariable int id) throws UserNotFoundException {
        User user = userService.getUser(id);
        return ResponseEntity.ok(userMapper.toResource(user));
    }

    @GetMapping("/name/{name}")
    public ResponseEntity<UserResource> getUserByName(@PathVariable String name) throws UserNotFoundException {
        User user = userService.getUserByName(name);
        return ResponseEntity.ok(userMapper.toResource(user));
    }
}
