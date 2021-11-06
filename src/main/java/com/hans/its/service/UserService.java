package com.hans.its.service;

import com.hans.its.entity.User;
import com.hans.its.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Slf4j
@RequiredArgsConstructor
@Service
public class UserService {
    private final UserRepository userRepository;

    public Mono<Long> count() {
        return userRepository.count();
    }

    public Flux<User> findAll() {
        return userRepository.findAll();
    }

    public Mono<User> addUser(User user) {
        return userRepository.save(user);
    }

    public Flux<User> addUsers(Flux<User> users) {
        return userRepository.saveAll(users);
    }

    public Mono<Void> deleteUser(Long id) {
        return userRepository.deleteById(id);
    }

    public Mono<Void> deleteAll() {
        return userRepository.deleteAll();
    }
}
