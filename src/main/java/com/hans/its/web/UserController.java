package com.hans.its.web;

import com.hans.its.entity.User;
import com.hans.its.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Slf4j
@RequiredArgsConstructor
@RestController
public class UserController {
    private final UserService userService;

    @GetMapping("users")
    public Flux<User> findAll() {
        return userService.findAll();
    }

    @PostMapping(value = "users", consumes = MediaType.APPLICATION_JSON_VALUE)
    public Mono<User> addUser(@RequestBody User user) {
        return userService.addUser(user);
    }

    @DeleteMapping(value = "users/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public Mono<Void> deleteUser(@PathVariable Long id) {
        return userService.deleteUser(id);
    }
}
