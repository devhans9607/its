package com.hans.its.repository;

import com.hans.its.entity.User;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface CustomUserRepository {
    Flux<User> findAllUser();
    Flux<User> findAllUserProjection();
    Mono<User> createUser(User User);
    Mono<User> updateUser(User user);
    Mono<User> updateUserByUntyped(User user);
    Mono<Void> removeUser(long uid);
}
