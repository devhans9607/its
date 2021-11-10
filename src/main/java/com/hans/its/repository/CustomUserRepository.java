package com.hans.its.repository;

import com.hans.its.entity.UserEntity;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface CustomUserRepository {
    Flux<UserEntity> findAllUser();
    Flux<UserEntity> findAllUserProjection();
    Mono<UserEntity> createUser(UserEntity User);
    Mono<UserEntity> updateUser(UserEntity user);
    Mono<UserEntity> updateUserByUntyped(UserEntity user);
    Mono<Void> removeUser(long uid);
}
