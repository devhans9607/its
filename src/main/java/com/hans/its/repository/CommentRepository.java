package com.hans.its.repository;

import com.hans.its.entity.CommentEntity;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;

public interface CommentRepository extends ReactiveCrudRepository<CommentEntity, Long> {
}
