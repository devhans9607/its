package com.hans.its.repository;

import com.hans.its.entity.UserEntity;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import reactor.core.publisher.Mono;

public interface UserRepository extends ReactiveCrudRepository<UserEntity, Long> /*, CustomUserRepository */ {
//    Mono<UserEntity> findUserEntityByUid(Mono<Integer> uid);
}
