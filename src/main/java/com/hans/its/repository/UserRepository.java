package com.hans.its.repository;

import com.hans.its.entity.User;
import org.springframework.data.r2dbc.repository.Query;
import org.springframework.data.r2dbc.repository.R2dbcRepository;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface UserRepository extends R2dbcRepository<User, Long> /*, CustomUserRepository */ {
    Mono<User> findUserEntityByUid(int uid);
    Mono<Integer> deleteUserEntityByUid(int uid);
    Mono<User> findUserEntityByUserId(String userId);

    @Query("select * from users where name = :name")
    Flux<User> findByName(String name);
}
