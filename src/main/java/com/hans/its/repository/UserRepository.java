package com.hans.its.repository;

import com.hans.its.entity.UserEntity;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;

public interface UserRepository extends ReactiveCrudRepository<UserEntity, Long>, CustomUserRepository {
}
