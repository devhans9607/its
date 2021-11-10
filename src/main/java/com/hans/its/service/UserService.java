package com.hans.its.service;

import com.hans.its.entity.UserEntity;
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
    private final UserRepository userRepo;

    public Flux<UserEntity> findAll() {
        return userRepo.findAll();
    }

//    public Flux<UserEntity> customFindAll() {
//        return userRepo.findAllUser();
//    }
//
//    public Flux<UserEntity> customFindAllProjection() {
//        return userRepo.findAllUserProjection();
//    }

    public Mono<UserEntity> createUser(UserEntity user) {
        return userRepo.save(user);
    }

//    public Mono<UserEntity> customCreateUser(UserEntity user) {
//        return userRepo.createUser(user);
//    }

    public Mono<UserEntity> updateUser(UserEntity user) {
        return userRepo.save(user);
    }

//    public Mono<UserEntity> customUpdateUser(UserEntity user) {
//        return userRepo.updateUser(user);
//    }
//
//    public Mono<UserEntity> customUpdateUserByUntyped(UserEntity user) {
//        return userRepo.updateUserByUntyped(user);
//    }

//    public Mono<Void> deleteUser(Long uid) {
//        return userRepo.delete(uid);
//    }

//    public Mono<Void> customDeleteUser(long id) {
//        return userRepo.removeUser(id);
//    }

}
